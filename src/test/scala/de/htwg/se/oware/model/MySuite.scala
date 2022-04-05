package de.htwg.se.oware
import org.scalatest.wordspec.AsyncWordSpec
import org.scalatest.matchers.should.Matchers._

class OwareSpe extends AsyncWordSpec:
    "Oware" should {
        "have a bar as String of form '+---+---+---+'" in {
            bar() should be("+---+---+---+" + System.lineSeparator)
        }
        "have a scalable bar" in {
            bar(1,1) should be("+-+" + System.lineSeparator)
            bar(2,2) should be("+--+--+" + System.lineSeparator)
            bar(3,1) should be("+---+" + System.lineSeparator)
        }
    }

    