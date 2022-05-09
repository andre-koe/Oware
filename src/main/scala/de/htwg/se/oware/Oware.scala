package de.htwg.se.oware
import de.htwg.se.oware.model.Field
import de.htwg.se.oware.aview.TUI
import scala.io.AnsiColor
import scala.io.StdIn.readLine
import de.htwg.se.oware.controller.Controller

val eol = System.lineSeparator

object Oware {
    var field = new Field(6)
    val controller = Controller(field)
    val tui = new TUI(controller)
    val welcome_msg = eol + AnsiColor.YELLOW + "Welcome to Oware!" + AnsiColor.RESET + eol

    def main(args: Array[String]): Unit = {
        var input = ""
        println(welcome_msg)

        controller.notifyObservers
        
        while (input != "q")
            input = readLine()
            tui.inputHandler(input)
            roundCount += 1
    } 
}
        
        

