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
      val cell_to_be_emptied = Cell(7)
      "have a value of zero" in {
        cell_to_be_emptied.empty.value should be(0)
      }
    }
  }
}