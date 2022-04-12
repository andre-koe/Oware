package de.htwg.se.oware
import de.htwg.se.oware.model.Field
import de.htwg.se.oware.model.Cell
import de.htwg.se.oware.model.Matrix

/*
TODO: Aufruf an diese Sturktur annähern
@main def run: Unit =
        println(eol + "Welcome to Oware!" + eol)
        val field = new Field(3, Stone.Empty)
        val controller = Controller(field)
        val tui = TUI(controller)
        tui.run
*/

val eol = System.lineSeparator;

@main def init: Unit =
        println(eol + "Welcome to Oware!" + eol)
        val v_1 : Vector[Cell] = Vector[Cell](Cell(0), Cell(1), Cell(2), Cell(3), Cell(4), Cell(5))
        val m_1 : Matrix = Matrix(v_1)
        var f = new Field(m_1)
        f = new Field(1)
        println(f)
        f = f.seed_from(0)
        println(f)

