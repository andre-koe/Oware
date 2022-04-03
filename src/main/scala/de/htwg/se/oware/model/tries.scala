case class Matrix[T](rows: Vector[Vector[T]]):
  def this(len: Int, filling: T) = this(Vector.tabulate(len, 3) { (row, col) => filling } )



val s1: Vector[Int] = Vector(1, 2, 3, 4)
val s2: Vector[Int] = Vector(3, 4, 5, 2)

val t: Matrix[Int] = Matrix(Vector(s1, s2))