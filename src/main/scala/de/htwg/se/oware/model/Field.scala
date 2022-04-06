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
    def seed_from(index:Int): Unit = {
        var no_of_cells: Int = cell(index).value
        cell(index).empty
    }
    def top_bar = (" /" + "-" * max_value.toString.length + "\\ ") * row_size
    def m: String = {
        var sb: StringBuilder = StringBuilder()
        for {
            cells <- 0 until row_size
        } sb.append("| " + cell(cells).toString + " |")
        sb.append(System.lineSeparator)
        sb.append(bot_bar)
        sb.append(System.lineSeparator)
        sb.append(top_bar)
        sb.append(System.lineSeparator)
        for {
            cells <- total_size-1 to row_size by -1
        } sb.append("| " + cell(cells).toString + " |")
        sb.toString
    }
    def bot_bar = (" \\" + "-" * max_value.toString.length + "/ ") * row_size

    override def toString: String = top_bar + System.lineSeparator + m + System.lineSeparator + bot_bar + System.lineSeparator
    
    