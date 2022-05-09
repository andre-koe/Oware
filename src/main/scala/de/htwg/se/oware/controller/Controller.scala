package de.htwg.se.oware.controller

import de.htwg.se.oware.model.Field
import de.htwg.se.oware.util.Observable
import de.htwg.se.oware.eol

class Controller(var field:Field) extends Observable:

  def seedControls(str: String): Option[Int] = {
    val m = Map("a" -> 0, "0" -> 0, "b" -> 1, "1" -> 1, 
                "c" -> 2, "2" -> 2, "d" -> 3, "3" -> 3,
                "e" -> 4, "4" -> 4, "f" -> 5, "5" -> 5)
    m.get(str)
  }

  def manageInput(input: Array[String]): Unit = {
    input(0) match
      case "s" => val idx = seedControls(input(1))
                  idx match
                    case None => field
                    case Some(idx) => if validateSeedConditions(idx) then field = seed(idx) else field = field
      case "n" => field = initField(6)
      case "h" | "r" => field
      case _ => field
      notifyObservers
  }

  def initField(size: Int): Field = new Field(size) 
  def seed(idx: Int): Field = field.seed_from(idx)
  def validateSeedConditions(idx: Int): Boolean = if field.cell(idx).value != 0 then true else false
  def fieldToString: String = field.toString