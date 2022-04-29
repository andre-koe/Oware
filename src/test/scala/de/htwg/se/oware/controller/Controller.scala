package de.htwg.se.oware.controller

import de.htwg.se.oware.model.Field
import de.htwg.se.oware.aview.TUI
import scala.io.AnsiColor

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import de.htwg.se.oware.controller.Controller

class ControllerSpec extends AnyWordSpec with Matchers {
  var field = new Field(6) 
  val controller = Controller(field)
  val tui = new TUI(controller)

  "The Controller, responsible for passing Data to the TUI " should {
      "init a field with the length of 6" in {
          var field = new Field(6) 
          val controller = Controller(field)
          controller.field should be(field)
      }
      "when fetched return the current field" in {
          var field = new Field(6) 
          val controller = Controller(field)
          controller.fetchData should be(field)
      }
      "when asked for validating player controls should return the appropriate Index" in {
          controller.seed_controls("a") should be(Some(0))
      }
      "when asked for invalid player controls should return none" in {
          controller.seed_controls("z") should be(None)
      }
      "when asked for the string representation of the standard field should return it" in {
          controller.fieldToString should be(field.toString)
      }
      "when asked for the string representation of the current field should return it" in {
          var field = new Field(3)
          controller.initField(3)
          controller.fieldToString should be(field.toString)
      }
      "when asked for the string representation of the currently changed field should return it" in {
          var field = new Field(3)
          field = field.seed_from(3)
          controller.initField(3)
          controller.seed(3)
          controller.fieldToString should be(field.toString)
      }
  }
}