package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor
import de.htwg.se.oware.util.Observer
import de.htwg.se.oware.controller.Controller


class TUI(controller: Controller) extends Observer:
    controller.add(this)

    val eof = System.lineSeparator

    val rules_string = AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eof + "=" * 10 + eof +
                "Oware is strategy game for 2 players." + eof +
                "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eof +
                "In each move the player has to seed from one of his non empty boxes." + eof + 
                "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eof +
                "until no stones remain in the box." + eof +
                "boxes can't be skipped" + eof +
                "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eof +
                "the box will be emptied and the seeding player will get those stones" + eof +
                "A player has to play in a way that the other player always has at least one stone to play with"

    val menu_string = AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eof +
                   "Command:" + " "*4 + "Action" + eof +
                   "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eof +
                   "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eof +
                   "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eof +
                   "q" + " "* (5 + ("Command".length - 1)) + "ends the game"

    def error_message(type_of: String, input:String) = AnsiColor.RED + "Unknown " + type_of + ": " + input + " enter h for help " + AnsiColor.RESET

    def sanitize_input(input: String): Array[String] = input.toLowerCase().stripLeading.split(" ")

    def player_controls(str: String): Option[Int] = {
    val m = Map("a" -> 0, "0" -> 0, "b" -> 1, "1" -> 1, 
                "c" -> 2, "2" -> 2, "d" -> 3, "3" -> 3,
                "e" -> 4, "4" -> 4, "f" -> 5, "5" -> 5)
    m.get(str)
  }

    def validate_input(input: String): Boolean = {
        val input_val = sanitize_input(input)
        input_val(0) match {
            case "n" | "new" | "r" | "rules" | "h" | "help" => true
            case "s" | "seed" => input_val.length >= 2
            case _ => false
        }
    }

    def input_processing(input: String): Unit = {
        val str = sanitize_input(input)
        if (validate_input(input)) {
            str(0) match {
                case "n" | "new"  => controller.initField(6)
                case "s" | "seed" => seed_from(str(1))                                     
                case "r" | "rules" => println(eof + rules_string + eof)
                case "h" | "help"  => println(eof + menu_string + eof)
            }
        } else {
            println(error_message("input", input))
        }
            
    }

    def seed_from(input: String): Unit = {
        val control = player_controls(input)
        control match {
            case Some(control) => controller.seed(control)
            case None => println(error_message("parameter", input))
        }
    }
    def update: Unit = println(controller.FieldToString)


        