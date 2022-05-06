package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor
import de.htwg.se.oware.util.Observer
import de.htwg.se.oware.controller.Controller
import de.htwg.se.oware.eol


class TUI(controller: Controller) extends Observer:
    controller.add(this)

    def goodbye = "Goodbye!"

    def rules = "Oware Rules:" + eol + "=" * 40 + eol +
                "Oware is strategy game for 2 players." + eol +
                "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eol +
                "In each move the player has to seed from one of his non empty boxes." + eol + 
                "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eol +
                "until no stones remain in the box." + eol +
                "boxes can't be skipped" + eol +
                "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eol +
                "the box will be emptied and the seeding player will get those stones" + eol +
                "A player has to play in a way that the other player always has at least one stone to play with"

    def help = "Menu: " + eol + "=" * 40 + eol +
                   "Command:" + " "*4 + "Action" + eol +
                   "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eol +
                   "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eol +
                   "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eol +
                   "q" + " "* (5 + ("Command".length - 1)) + "ends the game"

    def error_message(msg: String): String = eol + AnsiColor.RED + msg + " -> enter h for help" + AnsiColor.RESET + eol
    def menu_message(msg: String): String = eol + AnsiColor.YELLOW + msg + AnsiColor.RESET + eol

    def sanitize_input(input: String): Array[String] = input.toLowerCase().stripLeading.split(" ")

    def inputHandler(in: String): Unit = {
        val input = sanitize_input(in)
        input(0) match
            case "q" => println(menu_message(goodbye))
                        return
            case "h" => println(menu_message(help))
                        controller.manageInput(input)
            case "r" => println(menu_message(rules))
                        controller.manageInput(input)
            case "s"|"n" => 
                val idx = controller.seedControls(input(1))
                idx match
                    case None => println(error_message("Unknown parameter " + input(1)))
                    case Some(idx) => if !controller.validateSeedConditions(idx) then 
                        print(error_message("Cannot seed from empty box at index " + input(1)))
                controller.manageInput(input)
            case _ =>
                println(error_message("Unknown parameter " + input(0)))  
                controller.manageInput(input)
    }

    def update: Unit = println(controller.fieldToString)


        