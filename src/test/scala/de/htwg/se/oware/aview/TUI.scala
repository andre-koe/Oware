package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import de.htwg.se.oware.controller.Controller
import de.htwg.se.oware.eol

class TUISpec extends AnyWordSpec with Matchers {
  var field = new Field(6) 
  val controller = Controller(field)
  val tui = new TUI(controller)
        
  "The TUI" when {  
        "asked to say goodbye" should {
            "say goodbye as specified" in {
                tui.goodbye should be("Goodbye!")
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
                tui.help should be("Menu: " + eol + "=" * 40 + eol +
                                         "Command:" + " "*4 + "Action" + eol +
                                         "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eol +
                                         "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eol +
                                         "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eol +
                                         "q" + " "* (5 + ("Command".length - 1)) + "ends the game"
                                         )
            }
        }
        "asked for the rules string" should {
            "it should be as expected" in {
                tui.rules should be("Oware Rules:" + eol + "=" * 40 + eol +
                                          "Oware is strategy game for 2 players." + eol +
                                          "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eol +
                                          "In each move the player has to seed from one of his non empty boxes." + eol + 
                                          "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eol +
                                          "until no stones remain in the box." + eol +
                                          "boxes can't be skipped" + eol +
                                          "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eol +
                                          "the box will be emptied and the seeding player will get those stones" + eol +
                                          "A player has to play in a way that the other player always has at least one stone to play with"
                                         )
            }
        }

        "when returning a message in a message wrapper should respond" should {
            "in case of an error with a red message and -> enter h for help" in {
                tui.error_message("test") should be(eol + AnsiColor.RED + "test -> enter h for help" + AnsiColor.RESET + eol)
            }
            "in case of a menu response with a yellow message" in {
                tui.menu_message("test") should be(eol + AnsiColor.YELLOW + "test" + AnsiColor.RESET + eol)
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
                tui.inputHandler("s 3")
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
                tui.inputHandler("s z")
                controller.fieldToString should be(field.toString) 
            }
        }
    }
}