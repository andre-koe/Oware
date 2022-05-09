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
      "not be empty when add is called" in {
        emptyCell.add.isEmpty should be(false)
      }
    }
    "set with value 0 and 1 added" should {
      val addedCell = Cell(0).add
      "have value of 1" in {
        addedCell.value should be(1)
      }
    }
    "set with value 1 and 1 added" should {
      val addedCell = Cell(1).add
      "have a value of 2" in {
        addedCell.value should be(2)
      }
    }

    "set with value less or equal 2" should {
      val snackableCell = Cell(2)
      "be snackable" in {
        snackableCell.isSnackable should be(true)
      }
    }

    "set with value 0" should {
      val not_snackable_cell = Cell(0)
      "not be snackable" in {
        not_snackable_cell.isSnackable should be(false)
      }
    }

    "set with value >2" should {
      val not_snackable_cell = Cell(3)
      "not be snackable" in {
        not_snackable_cell.isSnackable should be(false)
      }
    }

    "turned into string" should {
      val cellToString = Cell(7).toString
      "have the appropriate value" in {
        cellToString should be("7")
      }
    }
    "emptied" should {
      val cell = Cell(7);
       "have a value of 0" in {
         cell.empty.value should be(0)
        }
      }

    "compared with another cell" should {
      val cell_one = Cell(3)
      val cell_two = Cell(7)

      "return a value of 1 if cell(7).compare(cell(3))" in {
        cell_two.compare(cell_one) should be(1)
      }
      "return a value of -1 if cell(3).compare(cell(7))" in {
        cell_one.compare(cell_two) should be(-1)
      }
      "return a value of 0 if cells have the same values" in {
        cell_one.compare(cell_one) should be(0)
      }
    }
  }
}