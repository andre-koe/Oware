package de.htwg.se.oware
import org.scalatest.wordspec.AsyncWordSpec
import org.scalatest.matchers.should.Matchers._

class OwareSpec extends AsyncWordSpec:
    val eof = System.lineSeparator

    "Oware" should {
        "have a bar as String of form '+---+---+---+'" in {
            bar() should be("+---+---+---+" + eof)
        }

        "have cells as String of form '|   |   |   |'" in {
            cells() should be("|   |   |   |" + eof)
        }
    }

    "bar" should {
        "be scalable" should {
            "bar(1,1) should be of form '+-+'" in {
                bar(1,1) should be("+-+" + eof)
            }

            "bar(2,2) should be of form '+--+--+'" in {
                bar(2,2) should be("+--+--+" + eof)
            }

            "bar(3,1) should be of form '+---+'" in {
                bar(3,1) should be("+---+" + eof)
            }
        } 
    }

    "cell" should {
        
        "be scalable" should {
            "be '|   |' for cells(3,1)" in {
                cells(3,1) should be("|   |" + eof)
            }

            "be '| | | |' for cells(1,3)" in {
                cells(1,3) should be("| | | |" + eof)
            }
        }
    }

    