package de.htwg.se.oware.model

case class Matrix(cols: Vector[Cell]):
    def this(size: Int, filling: Cell) = this(Vector.tabulate(size * 2) {i => filling})
    def total_length: Int = cols.size
    def row_length: Int = if ((total_length % 2) == 0) (total_length/2)  else 0
    def cell(index: Int): Cell  = cols(index % total_length)
    
    def populate_new(index: Int, value: Int): Matrix = {
        var temp_array: Array[Cell] = cols.toArray
        for {
            i <- index until index + temp_array(index).value + 1
        } 
        temp_array(i % total_length) = temp_array(i % total_length).add

        val zippedWithIndex = cols.zipWithIndex
        val idx = index % total_length
        val new_vector: Vector[Cell] = zippedWithIndex.map(
            i => 
                if (i._2 == idx) then Cell(cell(i._2).value / total_length)
                else Cell(temp_array(i._2).value)
        )
        Matrix(new_vector)
    }
    

