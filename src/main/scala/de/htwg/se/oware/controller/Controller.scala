package de.htwg.se.oware.controller

import de.htwg.se.oware.model.Field
import de.htwg.se.oware.util.Observable

class Controller(var field:Field) extends Observable:
  def initField(size: Int):Unit = {
    field = new Field(size)
    notifyObservers
  }
  def seed(idx: Int):Unit = {
    field = field.seed_from(idx)
    notifyObservers
  }
  def fetchData: Field = field
  def FieldToString: String = field.toString
