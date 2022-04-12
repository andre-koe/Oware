package de.htwg.se.oware.model

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import scala.compiletime.ops.boolean
import java.util.ArrayList

class FieldSpec extends AnyWordSpec with Matchers {
    "A Field" when {
        "initialized with new Field()" should {
            val testField = new Field();
            "have a total length of 12" in {
                testField.total_size should be(12)
            }
            "have a row length of 6" in {
                testField.row_size should be(6)
            }
            "contain only 4s" in {
                val t = testField._1.cols
                t.foreach(x => x.value should be (4))
            }
            "have a maximum value of 4" in {
                testField.max_value should be(4)
            }
            "return the cell on index 0 if cell(0) is called" in {
                testField.cell(0).empty.value should be(0)
            }
        }
        "turned into a string" should {            
            "have a toString representation which looks like this for new Field(1)" + System.lineSeparator +
              "     +---+" + System.lineSeparator +
              "     | 4 |" + System.lineSeparator +
              "     +---+" + System.lineSeparator +
              "     | 4 |" + System.lineSeparator +
              "     +---+" in {
                  val testField = new Field(1)
                  testField.toString should be ("+---+" + System.lineSeparator + 
                                                "| 4 |" + System.lineSeparator + 
                                                "+---+" + System.lineSeparator +
                                                "| 4 |" + System.lineSeparator +
                                                "+---+")
            }
              
            "have a toString representation which looks like this for new Field(2)" + System.lineSeparator +
              "     +---+---+" + System.lineSeparator +
              "     | 4 | 4 |" + System.lineSeparator +
              "     +---+---+" + System.lineSeparator +
              "     | 4 | 4 |" + System.lineSeparator +
              "     +---+---+" in {
                  val testField = new Field(2)
                  testField.toString should be ("+---+---+" + System.lineSeparator + 
                                                "| 4 | 4 |" + System.lineSeparator + 
                                                "+---+---+" + System.lineSeparator +
                                                "| 4 | 4 |" + System.lineSeparator +
                                                "+---+---+")
              }
        }
        "initialized with Cell values of 4 and with size 1 when seeded from 0" should {
            var testField = new Field(1)
            testField = testField.seed_from(0)
            "have a value of 6 at index 1" in {
                testField.cell(1).value should be(6)
            }

            "have a value of 2 at index 0" in {
                testField.cell(0).value should be(2)
            }

            "have a corresponding toString representation" in {
                testField.toString should be("+---+" + System.lineSeparator +
                                             "| 6 |" + System.lineSeparator +
                                             "+---+" + System.lineSeparator +
                                             "| 2 |" + System.lineSeparator +
                                             "+---+")
            }
        }
        "initialized with Cell values of 4 and with standard size 6 when seeded from 0" should {
            var testField = new Field(6)
            testField = testField.seed_from(1)
            "have the cell values 4 at index 0" in {
                testField.cell(0).value should be(4)
            }
            "have the cell values 0 at index 1" in {
                testField.cell(1).value should be(0)
            }
            "have the cell values 5 at index 2" in {
                testField.cell(2).value should be(5)
            }
            "have the cell values 5 at index 3" in {
                testField.cell(3).value should be(5)
            }
            "have the cell values 5 at index 4" in {
                testField.cell(4).value should be(5)
            }
            "have the cell values 5 at index 5" in {
                testField.cell(5).value should be(5)
            }

            "have a corresponding toString representation" in {
                testField.toString should be("+---+---+---+---+---+---+" + System.lineSeparator +
                                             "| 4 | 4 | 4 | 4 | 4 | 4 |" + System.lineSeparator +
                                             "+---+---+---+---+---+---+" + System.lineSeparator +
                                             "| 4 | 0 | 5 | 5 | 5 | 5 |" + System.lineSeparator +
                                             "+---+---+---+---+---+---+")
            }
        }
        
    } 
}
