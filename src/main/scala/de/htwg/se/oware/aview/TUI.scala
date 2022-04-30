package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor
import de.htwg.se.oware.util.Observer
import de.htwg.se.oware.controller.Controller


class TUI(controller: Controller) extends Observer:
    controller.add(this)

    val eof = System.lineSeparator

    def goodbye = AnsiColor.YELLOW + "Goodbye!" + AnsiColor.RESET

    def rules_string = AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eof + "=" * 10 + eof +
                "Oware is strategy game for 2 players." + eof +
                "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eof +
                "In each move the player has to seed from one of his non empty boxes." + eof + 
                "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eof +
                "until no stones remain in the box." + eof +
                "boxes can't be skipped" + eof +
                "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eof +
                "the box will be emptied and the seeding player will get those stones" + eof +
                "A player has to play in a way that the other player always has at least one stone to play with"

    def menu_string = AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eof + "=" * 10 + eof +
                   "Command:" + " "*4 + "Action" + eof +
                   "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eof +
                   "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eof +
                   "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eof +
                   "q" + " "* (5 + ("Command".length - 1)) + "ends the game"

    def error_message(domain: String, type_of: String, input:String): String = AnsiColor.RED + domain + " " + type_of + ": " + input + " enter h for help" + AnsiColor.RESET

    def sanitize_input(input: String): Array[String] = input.toLowerCase().stripLeading.split(" ")

    def input_handling(input: String): Unit = {
        val input_as = sanitize_input(input)
        input_as(0) match
            case "q" => println(goodbye)
            case "n" => controller.selectAndExecute(None)
            case "r" => println(eof + rules_string + eof)
                        update
            case "h" => println(eof + menu_string + eof)
                        update
                        controller.field
            case "s" => {
                val option = input_as(1)
                val index = controller.seed_controls(option)
                index match
                    case Some(index) => controller.selectAndExecute(Some(index))
                    case None => println(error_message("Unknown", "parameter", option))
            }
    }

    def update: Unit = println(controller.fieldToString)


        