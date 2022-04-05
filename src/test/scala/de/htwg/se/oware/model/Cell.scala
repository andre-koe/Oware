package de.htwg.se.oware.model

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class CellSpec extends AnyWordSpec with Matchers {
  "A Cell" when {
    "set with value of 0" should {
      val emptyCell = Cell(0)
      "be empty" in {
        emptyCell.isEmpty should be (true)
      }
      "not be snackable" in {
        emptyCell.isSnackable should be (false)
      }
    }
    "set with value 0 and 1 added" should {
      val addedCell = Cell(0).add
      "have value of 1" in {
        addedCell.value equals(1)
      }
    }
  }
}