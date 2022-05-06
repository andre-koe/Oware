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
  def selectAndExecute(toDo: Option[Int]): Unit = {
    toDo match 
      case None => field = initField(6)
      case Some(toDo) => field = if checkSeedConditions(toDo) then seed(toDo) else field
    notifyObservers
  }
  def initField(size: Int): Field = new Field(size) 
  def seed(idx: Int): Field = if checkSeedConditions(idx) then field.seed_from(idx) else field
  def checkSeedConditions(idx: Int): Boolean = if field.cell(idx).value == 0 then false else true
  def fieldToString: String = field.toString