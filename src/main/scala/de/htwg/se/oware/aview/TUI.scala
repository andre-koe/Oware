package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor


class TUI:
    val eof = System.lineSeparator

    def input_processing(input: String, field: Field): Field = {
        val str = input.split(" ")
        str(0) match {
            case "n" | "new" => new Field(6)
            case "s" | "seed" => if (str.length > 1) then 
                                    seed_from(str(1), field) 
                                else 
                                    println(AnsiColor.RED + "Missing parameter: " + input + " enter h for help " + AnsiColor.RESET)
                                    field
            case "r" | "rules" => println(show_rules)
                                  field
            case "h" | "help" => println(help)
                                 field
            case _ => println(AnsiColor.RED + "Unknown parameter: " + input + " enter h for help " + AnsiColor.RESET)
                      field
        }
    }

    def seed_from(input: String, field: Field): Field = {
        input match {
            case "A" | "0" => field.seed_from(0)
            case "B" | "1" => field.seed_from(1)
            case "C" | "2" => field.seed_from(2)
            case "D" | "3" => field.seed_from(3)
            case "E" | "4" => field.seed_from(4)
            case "F" | "5" => field.seed_from(5) 
            case _ => println(AnsiColor.RED + "Unknown parameter: " + input + " enter h for help " + AnsiColor.RESET)
                      field
        }
    }

    def show_rules: String = {
        val rules_intro = AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eof + "=" * 10 
        val rules_desc = "Oware is strategy game for 2 players." + eof +
                         "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones."
        val rules_seed = "In each move the player has to seed from one of his non empty boxes." + eof + 
                         "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eof +
                         "until no stones remain in the box." + eof +
                         "boxes can't be skipped"
        val rules_harv = "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eof +
                         "the box will be emptied and the seeding player will get those stones"
        val rules_c_moves = "A player has to play in a way that the other player always has at least one stone to play with"

        rules_intro + eof + rules_desc + eof + rules_seed + eof + rules_harv + eof + rules_c_moves
    }

    def help: String = {
        val menu = AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eof +
                   "Command:" + " "*4 + "Action" + eof +
                   "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eof +
                   "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eof +
                   "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eof +
                   "q" + " "* (5 + ("Command".length - 1)) + "ends the game"
        menu
    }


        