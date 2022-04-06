package de.htwg.se.oware.model

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CellSpec extends AnyWordSpec with Matchers {
  "A Cell" when {
    "set with value of 0" should {
      val emptyCell = Cell(0)
      "be empty" in {
        emptyCell.isEmpty should be(true)
      }
    }
    "set with value 0 and 1 added" should {
      val addedCell = Cell(0).add
      "have value of 1" in {
        addedCell.value equals(1)
      }
    }
    "set with value less or equal 2" should {
      val snackableCell = Cell(2)
      "be snackable" in {
        snackableCell.isSnackable should be(true)
      }
    }
    "turned into string" should {
      val cellToString = Cell(7).toString
      "have the appropriate value" in {
        cellToString equals("7")
      }
    }
    "emptied" should {
      val cell = Cell(7);
       "have a value of 0" in {
         cell.empty.value equals(0)
        }
      }
  }
}