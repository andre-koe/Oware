package de.htwg.se.oware
import de.htwg.se.oware.model.Field

/*
TODO: Aufruf an diese Sturktur annähern
@main def run: Unit =
        println(eol + "Welcome to Oware!" + eol)
        val field = new Field(3, Stone.Empty)
        val controller = Controller(field)
        val tui = TUI(controller)
        tui.run
*/

/*def test:Unit = {
        val s1: Vector[Int] = Vector(4, 4, 4);
        val s2: Vector[Int] = Vector(3, 4, 5)

        //val t: Matrix[Int] = Matrix(s1, s2)

        //println(t.toString)

        val s3: MyField = new MyField(2)
        
        println(s3._1)
        
}
*/

@main def init: Unit =
        //test
        //println(eol + "Welcome to Oware!" + eol)
        //println(mesh(3, cellNum = len_board))
        val f = new Field(6)
        f.seed_from(7)
        f.cell(2)
        printf(f.toString)

// Game description: http://joansala.com/auale/rules/en/
val len_board:Int = 1

val eol = System.lineSeparator
def bar(cellWidth: Int = 3, cellNum: Int = 3) =
        ("+" + "-" * cellWidth) * cellNum + "+" + eol
def cells(cellWidth:Int = 3, cellNum: Int = 3) =
        ("|" + " " * cellWidth) * cellNum + "|" + eol
def mesh(cellWidth: Int = 3, cellNum: Int =  3) =
        (bar(cellWidth, cellNum)
          + cells(cellWidth, cellNum)) * 2
          + bar(cellWidth, cellNum)