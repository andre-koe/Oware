import scala.io.AnsiColor
@main
def run=init

// EOF
def eof = System.lineSeparator;

// Holes to be played
val num_holes_in_row = 6
val hole_width = 5

// General appearance
val margin = 4
def color_yellow(value : String) = AnsiColor.YELLOW + value + AnsiColor.RESET
def color_red(value : String) = AnsiColor.RED + value + AnsiColor.RESET

// Hole appearance
val hole_top = "/" + "-" * hole_width + "\\"

def hole_mid(value : Int) = 
    if (value > 9)
        "|" + " " * ((hole_width + 2 - value.toString.length)/2) + value + " " * (hole_width-((hole_width + 2 - value.toString.length)/2)) + "|"
    else if (value > 0)
        "|" + " " * ((hole_width + 2 - value.toString.length)/2) + value + " " * (hole_width-((hole_width - value.toString.length)/2)) + "|"
    else 
        "|" + " " * (hole_width + 2) + "|"


def hole_bot(value : Char) = "\\" + "-" * (hole_width/2) + value + "-" * (hole_width/2) + "/"

// Collector Hole
val c_hole_tb = "{" + "-" * hole_width + "}" + " " * margin + color_red(" ||")

def c_hole_mid(value : Int) = 
    if (value > 9)
        "{" + " " * ((hole_width + 2 - value.toString.length)/2) + value + " " * (hole_width-((hole_width + 2 - value.toString.length)/2)) + "}" + " " * margin + color_red("||")
    else if (value > 0)
        "{" + " " * ((hole_width + 2 - value.toString.length)/2) + value + " " * (hole_width-((hole_width - value.toString.length)/2)) + "}" + " " * margin + color_red("||")
    else 
        "{" + " " * (hole_width + 2) + "}" + " " * margin + color_red("||")

// Bord Layout
def hole_section_top = color_red("||") + " " * margin * 2 + (hole_top + " " * margin) * num_holes_in_row + " " * (margin) + c_hole_tb
def hole_section_mid(value : Int, res : Int) = color_red("||") + " " * (margin * 2 - 1) + (hole_mid(value) + " " * (margin-2)) * num_holes_in_row + " " * (margin) + c_hole_mid(res)
def hole_section_bot = color_red("||") + " " * margin * 2 + (hole_bot('A') + " " * margin) * num_holes_in_row + " " * (margin) + c_hole_tb

def hole_section(value : Int, res:Int) = hole_section_top + eof + hole_section_mid(value, res) + eof + hole_section_bot


// Board Styling
val board_width = hole_section_mid(0,0).length - 2*color_red("||").length
def board_seperator = "||" + "o" * board_width + "||" + eof
def empty_seperator = "||" + " " * board_width + "||" + eof

// Title
val title = " " * (board_width/2) + AnsiColor.UNDERLINED + "Oware".toUpperCase + AnsiColor.RESET


def init=print(color_yellow(title) + eof *2 + 
               color_red(board_seperator) + 
               color_red(empty_seperator) + 
               hole_section(4, 0) + eof + 
               color_red(empty_seperator) + 
               color_red(board_seperator) + 
               color_red(empty_seperator) +
               hole_section(4, 0) + eof + 
               color_red(empty_seperator) +
               color_red(board_seperator) + eof)