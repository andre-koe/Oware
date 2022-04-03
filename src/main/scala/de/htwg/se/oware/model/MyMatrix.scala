package de.htwg.se.oware.model

case class MyMatrix[T](private val cols: Vector[T]):
    def this(size: Int, filling: T) = this(Vector.tabulate(size * 2) {i => filling})
    def total_length: Int = cols.size
    def row_length: Int = total_length / 2
