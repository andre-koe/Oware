package de.htwg.se.oware.model

case class Field(private val cells: Matrix[Cell]):
    def this(size: Int = 6) = this(new Matrix[Cell](size, Cell(4)))
    val total_size = cells.total_length
    val row_size = cells.row_length;
    def cell(index: Int): Cell = cells.cell(index)
    def max_value: Int = {
        var max = Integer.MIN_VALUE;
        for (i <- 0 to total_size) {
            if (cell(i).value > max) {
                max = cell(i).value
            }
        }
        max
    }
    
    