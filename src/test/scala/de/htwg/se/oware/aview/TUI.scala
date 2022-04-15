package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field
import scala.io.AnsiColor

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class TUISpec extends AnyWordSpec with Matchers {
  "The TUI" when {
    val tui = new TUI
    val eof = System.lineSeparator
    var field: Field = new Field(6)
    "input_processing()" should {
        "respond by returning the standard field when no input is provided" in {
            tui.input_processing("", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard field when wrong input is provided" in {
            tui.input_processing("hallo", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard field when h is provided" in {
            tui.input_processing("h", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard field when help is provided" in {
            tui.input_processing("help", field).toString should be(tui.input_processing("h", field).toString)
        }
        "respond by returning the standard field when n is provided" in {
            tui.input_processing("n", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard field when new is provided" in {
            tui.input_processing("new", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard when r is provided" in {
            tui.input_processing("r", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard field when rules is provided" in {
            tui.input_processing("rules", field).toString should be(tui.input_processing("r", field).toString)
        }
        "respond by returning the standard field when s is provided" in {
            tui.input_processing("s", field).toString should be(new Field(6).toString)
        }
        "respond by returning the standard field" in {
            tui.input_processing("seed", field).toString should be(tui.input_processing("s", field).toString)
        }
    }
    "input_processing()" should {
        "respond by returning the field new Field(6).seed_from(0).toString when seeded from index 0" in {
            var f = tui.input_processing("s 0", field)
            f.toString should be(new Field(6).seed_from(0).toString)
        }
        "respond by returning the same field as before when seeded from index A" in {
            tui.input_processing("s A", field).toString should be(tui.input_processing("s 0", field).toString)
        }
        "respond by returning the field new Field(6).seed_from(1).toString seeded from index 1" in {
            var f = tui.input_processing("s 1", field)
            f.toString should be(new Field(6).seed_from(1).toString)
        }
        "respond by returning the same field as before when seeded from index B" in {
            tui.input_processing("s B", field).toString should be(tui.input_processing("s 1", field).toString)
        }
        "respond by returning the field new Field(6).seed_from(2).toString when seeded from index 2" in {
            var f = tui.input_processing("s 2", field)
            f.toString should be(new Field(6).seed_from(2).toString)
        }
        "respond by returning the same field as before" in {
            tui.input_processing("s C", field).toString should be(tui.input_processing("s 2", field).toString)
        }
         "respond by returning the field new Field(6).seed_from(3).toString seeded from index 3" in {
            var f = tui.input_processing("s 3", field)
            f.toString should be(new Field(6).seed_from(3).toString)
        }
        "respond by returning the same field as before when seeded from index C from index 3" in {
            tui.input_processing("s D", field).toString should be(tui.input_processing("s 3", field).toString)
        }
        "respond by returning the field new Field(6).seed_from(4).toString when seeded from index 4" in {
            var f = tui.input_processing("s 4", field)
            f.toString should be(new Field(6).seed_from(4).toString)
        }
        "respond by returning the same field as before when seeded from index 4" in {
            tui.input_processing("s E", field).toString should be(tui.input_processing("s 4", field).toString)
        }
        "respond by returning the field new Field(6).seed_from(5).toString when seeded from index 5" in {
            var f = tui.input_processing("s 5", field)
            f.toString should be(new Field(6).seed_from(5).toString)
        }
        "respond by returning the same field as before when seeded from index F" in {
            tui.input_processing("s F", field).toString should be(tui.input_processing("s 5", field).toString)
        }
        "respond by returning the standard field when seeded with wrong input" in {
            var f = tui.input_processing("s K", field)
            f.toString should be(new Field(6).toString)
        }
    }
    "asked for help" should {
        "return menu text once help() is called" in {
            tui.help should be(AnsiColor.YELLOW + "Menu: " +  AnsiColor.RESET + eof +
                               "Command:" + " "*4 + "Action" + eof +
                               "n" + " "* (5 + ("Command".length - 1)) + "restart the game" + eof +
                               "s n" + " "* (5 + ("Command".length - 3)) + "seed from box with index n [A-F|0-5]" + eof +
                               "h" + " "* (5 + ("Command".length - 1)) + "Show help" + eof +
                               "q" + " "* (5 + ("Command".length - 1)) + "ends the game")
        }
        "return rules text once show_rules() is called" in {
            tui.show_rules should be(AnsiColor.YELLOW + "Oware Rules:" + AnsiColor.RESET + eof + "=" * 10 + eof +
                         "Oware is strategy game for 2 players." + eof +
                         "Every player has 6 boxes in front of him each of which contains 4 stones. In total 48 stones." + eof +
                         "In each move the player has to seed from one of his non empty boxes." + eof + 
                         "E.g. the stones are transfered one by one into the neighbouring boxes, (counter clockwise)" + eof +
                         "until no stones remain in the box." + eof +
                         "boxes can't be skipped" + eof +
                         "If an enemy box in which stones have been transfered during the previous seeding contains exactly 2 or 3 stones" + eof +
                         "the box will be emptied and the seeding player will get those stones" + eof +
                         "A player has to play in a way that the other player always has at least one stone to play with")
        }
    }
    
  }
}