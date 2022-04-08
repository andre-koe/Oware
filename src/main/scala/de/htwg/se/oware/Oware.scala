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

val eol = System.lineSeparator;

@main def init: Unit =
        println(eol + "Welcome to Oware!" + eol)
        val f = new Field(1)
        f.cell(0).add
        println(f)

