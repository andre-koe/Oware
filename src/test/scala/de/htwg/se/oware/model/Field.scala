package de.htwg.se.oware.model

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import scala.compiletime.ops.boolean

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
        
    } 
}
