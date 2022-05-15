package de.htwg.se.oware.controller
import de.htwg.se.oware.model.Field

trait SeedManager {
    def executeSeed(idx: Int, field: Field): Field
}

case class SeedSuccessfull(controller: Controller) extends SeedManager {
    def executeSeed(idx: Int, field: Field): Field = {
        if controller.validateSeedConditions(idx) then controller.seed(idx)
        else controller.field
    }
}

case class SeedUnsuccessfull(controller: Controller) extends SeedManager {
    def executeSeed(idx: Int, field: Field): Field = {
        controller.field
    }
}

// Factory
object SeedSelector:
    def apply(controller: Controller, idx: String): Field = {
        // Monade 1
        controller.seedControls(idx) match
            case Some(idx) => SeedSuccessfull(controller).executeSeed(idx, controller.field)
            case None => SeedUnsuccessfull(controller).executeSeed(0, controller.field)
    }