package de.htwg.se.oware.model

case class Matrix(cols: Vector[Cell]):
    def this(size: Int, filling: Cell) = this(Vector.tabulate(size * 2) {i => filling})
    def total_length: Int = cols.size
    def row_length: Int = if ((total_length % 2) == 0) (total_length/2)  else 0
    def cell(index: Int): Cell  = cols(index % total_length)
    def populate_new(index: Int, value: Int): Matrix = {
        var temp_array: Array[Cell] = new Array(total_length)
        cols.copyToArray(temp_array)
        var just_started = true
        for {
            i <- index until index + temp_array(index).value + 1
        } 
        if (i % total_length == index && just_started) then
            temp_array(i) = Cell(0)
            just_started = false
        else 
            temp_array(i % total_length) = temp_array(i % total_length).add

        Matrix(temp_array.toVector)
    }


    /* Alternative but complex solution without the use of mutable datatypes */
    /* Currently not working */
    /* Probably better with Vector[Vector[Cell]] Construct */
    /*
        val zippedWithIndex = cols.zipWithIndex
        val idx = index % total_length
        val remaining_in_row = total_length - idx
        val in_next_row = if ((cell(idx).value + idx) - total_length > 0) then (cell(idx).value + idx) - total_length else -1
        val new_vector = zippedWithIndex.map(
            i => 
            if (i._2 == idx) then cell(i._2).empty
            else if ((i._2 > index && i._2 <= index + value) || 
                (i._2 <= (cell(index).value - (row_length - (index % total_length) % row_length)))) then Cell(cell(i._2).value).add
            else cell(i._2)
        )   

        for (i <- 0 until total_length) {
            println(zippedWithIndex(i)._2)
        }
    */

