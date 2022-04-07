package de.htwg.se.oware.model

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MatrixSpec extends AnyWordSpec with Matchers {
    "A Matrix" when {
        "initialized with vector a = [Cell(1)]" should {
            val m: Matrix[Cell] = Matrix(Vector.tabulate(1) {i => Cell(1)})
            "have a total length of 1" in {
                m.total_length should be(1)
            }
            "have a row length of 0" in {
                m.row_length should be(0)
            }
            "return always the value 1 for any input index" in {
                m.cell(3).value should be(1)
            }
        }
        "initialized with length of 1 and filling of Cell(2)" should {
            val m: Matrix[Cell] = new Matrix(1, Cell(2))
            "have a total length of 2" in {
                m.total_length should be(2)
            }
            "have a row length of 1" in {
                m.row_length should be(1)
            }
            "allow for adding values" in {
                m.cell(1).add.value should be(3)
            }
        }
    }
}