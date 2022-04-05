package de.htwg.se.oware.model

case class Field(private val cells: Matrix[Cell]):
    def this(size: Int) = this(new Matrix[Cell](size, Cell(4)))
    val total_size = cells.total_length
    val row_size = cells.row_length;
    def cell(index: Int) = cells.cell(index)

    def top_bar = "/" + "-" * cells.max.toString.length + "\\"
    def m: String = {
        var sb: StringBuilder = StringBuilder()
        for {
            cells <- 0 until row_size
        } sb.append("| " + cell.toString + " |")
        sb.toString;
    }
    def bot_bar = "\\" + "-" * cells.max.toString.length + "/"

    override def toString: String = top_bar + System.lineSeparator + m + System.lineSeparator + bot_bar
    
    