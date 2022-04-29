package de.htwg.se.oware.controller

import de.htwg.se.oware.model.Field
import de.htwg.se.oware.util.Observable

class Controller(var field:Field) extends Observable:

  def seed_controls(str: String): Option[Int] = {
    val m = Map("a" -> 0, "0" -> 0, "b" -> 1, "1" -> 1, 
                "c" -> 2, "2" -> 2, "d" -> 3, "3" -> 3,
                "e" -> 4, "4" -> 4, "f" -> 5, "5" -> 5)
    m.get(str)
  }

  def initField(size: Int): Unit = { 
    field = new Field(size) 
    notifyObservers
  }
  def seed(idx: Int): Unit = {
    field = field.seed_from(idx)
    notifyObservers
  }
  def fetchData: Field = field
  def fieldToString: String = field.toString
