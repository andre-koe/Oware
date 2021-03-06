package de.htwg.se.oware.controller

import de.htwg.se.oware.model.Field
import de.htwg.se.oware.aview.TUI
import scala.io.AnsiColor

import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import de.htwg.se.oware.controller.Controller

class ControllerSpec extends AnyWordSpec with Matchers {
  var field = new Field(6) 
  val controller = Controller(field)
  val tui = new TUI(controller)

  "The Controller, responsible for passing Data to the TUI " should {
      "init a field with the length of 6" in {
          var field = new Field(6) 
          controller.initField(6) should be(field)
      }
      "when asked for the field should return the current field" in {
          var field = new Field(6) 
          val controller = Controller(field)
          controller.field should be(field)
      }
      "when asked for validating player controls should return the appropriate Index" in {
          controller.seedControls("a") should be(Some(0))
      }
      "when asked for invalid player controls should return none" in {
          controller.seedControls("z") should be(None)
      }
      "when asked for the string representation of the standard field should return it" in {
          controller.fieldToString should be(field.toString)
      }
      "when asked for the string representation of the current field should return it" in {
          var field = new Field(3)
          controller.initField(3).toString should be(field.toString)
      }
      "when asked for the string representation of the currently changed field should return it" in {
          var field = new Field(6)
          field = field.seed_from(3)
          controller.seed(3) should be(field)
      }
      "when checking seed conditions regarding an user input should return false if it's not possible" in {
          var field = new Field(6)
          val controller = Controller(field)
          val a: Array[String] = new Array(2)
          a(0) = "s"
          a(1) = "3"
          controller.manageInput(a)
          controller.validateSeedConditions(3) should be(false)
      }
      "when checking seed conditions regarding an user input should return true if it's possible" in {
          var field = new Field(6)
          val controller = Controller(field)
          controller.seed(3)
          val c = controller.validateSeedConditions(1) should be(true)
      }
      "initialize a new field when manageInput(n) is called" in {
          var field = new Field(6)
          val a: Array[String] = new Array(2)
          a(0) = "n"
          a(1) = " "
          val controller = Controller(field)
          controller.manageInput(a)
          controller.fieldToString should be(field.toString)
      }
      "respond with the unchanged field when manageInput(h) is called" in {
          var field = new Field(6)
          val a: Array[String] = new Array(2)
          a(0) = "h"
          a(1) = " "
          val controller = Controller(field)
          controller.manageInput(a)
          controller.fieldToString should be(field.toString)
      }
      "respond with the unchanged field when manageInput(r) is called" in {
          var field = new Field(6)
          val a: Array[String] = new Array(2)
          a(0) = "r"
          a(1) = " "
          val controller = Controller(field)
          controller.manageInput(a)
          controller.fieldToString should be(field.toString)
      }
      "respond with a flipped field when flip field is called" in {
          var field = new Field(6)
          val a: Array[String] = new Array(2)
          a(0) = "s"
          a(1) = "1"
          val controller = Controller(field)
          controller.manageInput(a)
          controller.flipField.toString should be("+---+---+---+---+---+---+" + System.lineSeparator +
                                       "| 4 | 0 | 5 | 5 | 5 | 5 |" + System.lineSeparator +
                                       "+---+---+---+---+---+---+" + System.lineSeparator +
                                       "| 4 | 4 | 4 | 4 | 4 | 4 |" + System.lineSeparator +
                                       "+---+---+---+---+---+---+")
      }
  }
}