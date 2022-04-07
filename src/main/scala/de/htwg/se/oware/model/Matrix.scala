package de.htwg.se.oware.model

case class Matrix[T](cols: Vector[T]):
    def this(size: Int, filling: T) = this(Vector.tabulate(size * 2) {i => filling})
    def total_length: Int = cols.size
    def row_length: Int = if ((total_length % 2) == 0) (total_length/2)  else 0
    def cell(index: Int): T = cols(index % total_length);