package de.htwg.se.oware
import de.htwg.se.oware.model.Field
import de.htwg.se.oware.aview.TUI
import scala.io.AnsiColor
import scala.io.StdIn.readLine

val eol = System.lineSeparator

object Oware {
    val tui = new TUI
    var field = new Field(6)

    def main(args: Array[String]): Unit = {
        var input = ""
        println(eol + AnsiColor.YELLOW + "Welcome to Oware!" + AnsiColor.RESET + eol)

        println(field.toString)
        

        while (input != "q")
            input = readLine()
            field = tui.input_processing(input, field)
            println(field.toString)
    } 
}
        
        

