package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor
import de.htwg.se.oware.util.Observer
import de.htwg.se.oware.controller.Controller
import de.htwg.se.oware.eol


class TUI(controller: Controller) extends Observer:
    controller.add(this)

    def goodbye = AnsiColor.YELLOW + "Goodbye!" + AnsiColor.RESET

    def rules_string = AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eol + "=" * 10 + eol +
                "Oware is strategy game for 2 players." + eol +
                "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eol +
                "In each move the player has to seed from one of his non empty boxes." + eol + 
                "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eol +
                "until no stones remain in the box." + eol +
                "boxes can't be skipped" + eol +
                "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eol +
                "the box will be emptied and the seeding player will get those stones" + eol +
                "A player has to play in a way that the other player always has at least one stone to play with"

    def menu_string = AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eol + "=" * 10 + eol +
                   "Command:" + " "*4 + "Action" + eol +
                   "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eol +
                   "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eol +
                   "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eol +
                   "q" + " "* (5 + ("Command".length - 1)) + "ends the game"

    def error_message(msg: String, input: String): String = eol + AnsiColor.RED + msg + ": " + input + " -> enter h for help" + AnsiColor.RESET + eol

    def sanitize_input(input: String): Array[String] = input.toLowerCase().stripLeading.split(" ")

    def input_handling(input: String): Unit = {
        val input_as = sanitize_input(input)
        input_as(0) match
            case "q" => println(goodbye)
            case "n" => controller.selectAndExecute(None)
            case "r" => println(eol + rules_string + eol)
                        update
            case "h" => println(eol + menu_string + eol)
                        update
            case "s" => {
                val option = input_as(1)
                val index = controller.seedControls(option)
                index match
                    case Some(index) => if controller.checkSeedConditions(index) then controller.selectAndExecute(Some(index)) 
                                        else {
                                                println(error_message("Not able to seed from empty box with index:", index.toString))
                                                update
                                        }
                    case None => println(error_message("Unknown parameter", option))
            }
            case default => println(error_message("Unknown command", default))
    }

    def update: Unit = println(controller.fieldToString)


        