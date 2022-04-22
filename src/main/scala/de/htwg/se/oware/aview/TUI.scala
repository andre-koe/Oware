package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor
import de.htwg.se.oware.util.Observer
import de.htwg.se.oware.controller.Controller


class TUI(controller: Controller) extends Observer:
    controller.add(this)

    val eof = System.lineSeparator

    val rules = AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eof + "=" * 10 + eof +
                "Oware is strategy game for 2 players." + eof +
                "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eof +
                "In each move the player has to seed from one of his non empty boxes." + eof + 
                "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eof +
                "until no stones remain in the box." + eof +
                "boxes can't be skipped" + eof +
                "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eof +
                "the box will be emptied and the seeding player will get those stones" + eof +
                "A player has to play in a way that the other player always has at least one stone to play with" + eof

    def input_processing(input: String): Unit = {
        val str = input.split(" ")
        str(0) match {
            case "n" | "new" => controller.initField(6)
            case "s" | "seed" => if (str.length > 1) then 
                                    seed_from(str(1)) 
                                else 
                                    println(AnsiColor.RED + "Missing parameter: " + input + " enter h for help " + AnsiColor.RESET)
            case "r" | "rules" => println(show_rules)
            case "h" | "help" => println(help)
            case _ => println(AnsiColor.RED + "Unknown parameter: " + input + " enter h for help " + AnsiColor.RESET)
        }
    }

    def seed_from(input: String): Unit = {
        input match {
            case "A" | "0" => controller.seed(0)
            case "B" | "1" => controller.seed(1)
            case "C" | "2" => controller.seed(2)
            case "D" | "3" => controller.seed(3)
            case "E" | "4" => controller.seed(4)
            case "F" | "5" => controller.seed(5) 
            case _ => println(AnsiColor.RED + "Unknown parameter: " + input + " enter h for help " + AnsiColor.RESET)
        }
    }
    /*TODO: REMOVED*/
    def show_rules: String = {
        rules
    }

    /*TODO: BE REMOVED*/
    def help: String = {
        val menu = AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eof +
                   "Command:" + " "*4 + "Action" + eof +
                   "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eof +
                   "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eof +
                   "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eof +
                   "q" + " "* (5 + ("Command".length - 1)) + "ends the game"
        menu
    }
    
    def update: Unit = println(controller.FieldToString)


        