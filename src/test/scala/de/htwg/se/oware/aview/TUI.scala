package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import de.htwg.se.oware.controller.Controller

class TUISpec extends AnyWordSpec with Matchers {
  val eof = System.lineSeparator
  var field = new Field(6) 
  val controller = Controller(field)
  val tui = new TUI(controller)
        
  "The TUI" when {    
        "encountering a faulty user input" should {
            "return a color coded string as specified" in {
                tui.error_message("Unknown", "parameter", "k") should be(AnsiColor.RED + "Unknown parameter: k enter h for help" + AnsiColor.RESET)
            }
        }
        "fed a string (user input)" should {
            "digest it and turn it into an array of strings containing the parts of the string" in {
                var a = new Array[String](2)
                a(0) = "hello"
                a(1) = "world"
                tui.sanitize_input("hello world") should be(a)
            }
            "it should also remove leading whitespaces" in {
                var a = new Array[String](2)
                a(0) = "hello"
                a(1) = "world"
                tui.sanitize_input("     hello world") should be(a)
            }
        }
        "asked for the menu string" should {
            "it should be as expected" in {
                tui.menu_string should be(AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eof + "=" * 10 + eof +
                                         "Command:" + " "*4 + "Action" + eof +
                                         "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eof +
                                         "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eof +
                                         "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eof +
                                         "q" + " "* (5 + ("Command".length - 1)) + "ends the game"
                                         )
            }
        }
        "asked for the rules string" should {
            "it should be as expected" in {
                tui.rules_string should be(AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eof + "=" * 10 + eof +
                                          "Oware is strategy game for 2 players." + eof +
                                          "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eof +
                                          "In each move the player has to seed from one of his non empty boxes." + eof + 
                                          "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eof +
                                          "until no stones remain in the box." + eof +
                                          "boxes can't be skipped" + eof +
                                          "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eof +
                                          "the box will be emptied and the seeding player will get those stones" + eof +
                                          "A player has to play in a way that the other player always has at least one stone to play with"
                                         )
            }
        }
        "removed from the list of observers " should {
            "lead to an empty controller list " in {
                controller.remove(tui)
                controller.subscribers.length should be(0)
            }
        }
        "seeded with valid input it" should {
            "should yield in the correctly seeded field" in {
                tui.seed_from("3")
                var field = new Field(6)
                field = field.seed_from(3)
                controller.fieldToString should be(field.toString) 
            }
        }
        "seeded with non valid input it" should {
            "leave the field as it is" in {
                var field = new Field(6) 
                val controller = Controller(field)
                val tui = new TUI(controller)
                tui.seed_from("z")

                controller.fieldToString should be(field.toString) 
            }
        }
    }
}