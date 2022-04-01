package de.htwg.se.oware.model

case class Matrix[T](rows: Vector[Vector[T]]):
  def this(len: Int, filling: T) = this(Vector.tabulate(len, 2) { (row, col) => filling } )