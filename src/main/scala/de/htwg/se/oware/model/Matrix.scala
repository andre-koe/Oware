package de.htwg.se.oware.model

case class Matrix[T](cols: Vector[T]):
    def this(size: Int, filling: T) = this(Vector.tabulate(size * 2) {i => filling})
    def total_length: Int = cols.size
    def row_length: Int = total_length / 2
    def cell(index: Int) = cols(index % total_length);

    def max = 10;