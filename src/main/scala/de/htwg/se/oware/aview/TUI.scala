package de.htwg.se.oware.aview
import de.htwg.se.oware.model.Field


class TUI:

    val eof = System.lineSeparator

    def input_processing(input: String): Unit = {
        input match {
            case "n" => new Field(6)
            case "s" => new Field(6).seed_from(1)
            case "r" => println(show_rules)
            case "h" => println(help)
        }
    }

    def show_rules: String = {
        val rules_intro ="Oware Regeln:" + eof + "=" * 10 
        val rules_desc = "Oware ist ein Zweispieler Strategiespiel" + eof +
                         "Jeder Spieler hat 6 Kästchen vor sich in jedem Kästchen sind 4 Steine. Insgesamt sind es also 48 Steine."
        val rules_seed = "In seinem Zug muss ein Spieler Steine verteilen." + eof + 
                         "Dazu leert der Spieler eines seiner nichtleeres Kästchen vollständig." + eof +
                         "Die Steine werden einzeln gegen den Uhrzeigersinn in die benachbarten Kästchen gelegt. Es darf keine Mulde übersprungen werden."
        val rules_harv = "Enthält ein Kästchen (in das Steine Verteilt wurden) auf Seiten des Gegners nach dem Verteilen 2 oder 3 Steine wird das Kästchen geleert" + eof +
                         "und die Steine werden aus dem Spiel genommen und dem Verteilenden Spieler gut geschrieben"
        val rules_c_moves = "Ein Spieler hat die Verpflichtung so zu spielen, dass sein Gegenspieler Steine zum Spielen hat:" + eof +
                            "Wenn es Züge gibt, die den Gegner ohne Steine lassen, und es Züge gibt, die dem Gegner Steine lassen oder geben, so dass er ziehen kann," + eof + 
                            "dann muss ein Zug der letzteren Art gemacht werden."

        rules_intro + eof + rules_desc + eof + rules_seed + eof + rules_harv + eof + rules_c_moves
    }

    def help: String = {
        val menu = "Menü: " + eof +
                   "Eingabe:" + " "* 5 + "Aktion" + eof +
                   "n" + " "* (5 + ("Eingabe".length - 1)) + "Erstelle ein neues Spielbrett" + eof +
                   "s n" + " "* (5 + ("Eingabe".length - 3)) + "Seed von Kästchen mit Index n" + eof +
                   "h" + " "* (5 + ("Eingabe".length - 1)) + "Zeige dieses Menü an"
        menu
    }


        