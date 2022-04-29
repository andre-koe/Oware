package de.htwg.se.oware.model


case class Cell(value: Int) extends Ordered[Cell]{
  def isEmpty: Boolean = value == 0
  def isSnackable: Boolean = value <= 2 && value >= 1
  def add: Cell = Cell(value + 1)
  def empty: Cell = Cell(0)
  override def compare(o: Cell) = 
    if  this.value > o.value then
      +1
    else if this.value == o.value then
       0
    else 
      -1
    end if

  override def toString: String = value.toString;
  
}