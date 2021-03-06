package de.htwg.se.oware.model

case class Field(private val cells: Matrix):
    def this(size: Int = 6) = this(new Matrix(size, Cell(4)))
    
    val total_size = cells.total_length
    val row_size = cells.row_length;

    def cell(index: Int): Cell = cells.cell(index)
    def max_value: Int = cells.cols.max.value
    def seed_from(index: Int) : Field = Field(cells.populate_new(index % total_size, cells.cell(index).value))
    def swapField(): Field = Field(cells.swapParts())

    override def toString = 
        val h_bar = ("+-" + "-" * max_value.toString.length + "-") * row_size + "+"
        val v_bar = ("|" + " "* max_value.toString.length + "k" + " ") * row_size + "|"
        var row = h_bar + System.lineSeparator + v_bar

        for {
            x <- total_size-1 to row_size by -1
        } if (cells.cell(x).value > 9) then row = row.replaceFirst(" k", cells.cell(x).toString)
          else row = row.replaceFirst("k", cells.cell(x).toString)
        row = row.concat(System.lineSeparator + h_bar + System.lineSeparator + v_bar + System.lineSeparator + h_bar )

        for {
            x <- 0 until row_size
        } if (cells.cell(x).value > 9) then row = row.replaceFirst(" k", cells.cell(x).toString)
          else row = row.replaceFirst("k", cells.cell(x).toString)
        row
    
    