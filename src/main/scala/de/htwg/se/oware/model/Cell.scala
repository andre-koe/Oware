package de.htwg.se.oware.model


case class Cell(value: Int) {
  def isEmpty: Boolean = value == 0
  def isSnackable: Boolean = value >= 2
  def add: Cell = Cell(value + 1)
  def empty: Cell = Cell(0)
}