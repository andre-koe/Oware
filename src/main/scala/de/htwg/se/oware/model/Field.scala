package de.htwg.se.oware.model

case class Field(private val cells: Matrix[Cell]):
    def this(size: Int = 6) = this(new Matrix[Cell](size, Cell(4)))
    val total_size = cells.total_length
    val row_size = cells.row_length;
    def cell(index: Int): Cell = cells.cell(index)
    def max_value: Int = {
        var max = Integer.MIN_VALUE;
        this._1.cols.foreach(x => if (x.value > max) {max  = x.value})
        max
    }

    def h_bar = ("+-" + "-" * max_value.toString.length + "-") * row_size + "+"
    def v_bar = ("| " + " " * max_value.toString.length + " ") * row_size + "|"

    def row = h_bar + System.lineSeparator + v_bar;
    override def toString = row + System.lineSeparator + row + System.lineSeparator + h_bar
    
    