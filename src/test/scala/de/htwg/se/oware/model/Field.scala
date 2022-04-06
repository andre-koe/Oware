package de.htwg.se.oware.model

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class FieldSpec extends AnyWordSpec with Matchers {
    "A Field" when {
        "initialized with new Field()" should {
            val testField = new Field();
            "have a total length of 12" in {
                testField.total_size equals(12)
            }
            "have a row length of 6" in {
                testField.row_size equals(6)
            }
            "contain only 4s" in {
                var only4s: Boolean = true
                var index = 0
                while (index < testField.total_size) {
                    if (testField.cell(index).value != 4) {
                        only4s = false
                        index += 100
                    }
                    index += 1
                }
                only4s should be(true)
            }
            "have a maximum value of 4" in {
                testField.max_value equals(4)
            }
        }
        "initialized with new Field(1)"
    } 
}
