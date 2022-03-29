import scala.io.AnsiColor

@main def init: Unit =
        println(eol + "Welcome to Oware!" + eol)
        println(mesh(3, cellNum = len_board))

// Game description: http://joansala.com/auale/rules/en/
val len_board:Int = 1

val eol = sys.props("line.separator")
def bar(cellWidth: Int = 3, cellNum: Int = 3) =
        ("+" + "-" * cellWidth) * cellNum + "+" + eol
def cells(cellWidth:Int = 3, cellNum: Int = 3) =
        ("|" + " " * cellWidth) * cellNum + "|" + eol
def mesh(cellWidth: Int = 3, cellNum: Int =  3) =
        (bar(cellWidth, cellNum)
          + cells(cellWidth, cellNum)) * 2
          + bar(cellWidth, cellNum)