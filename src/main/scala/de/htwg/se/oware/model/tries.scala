case class Matrix[T](rows: Vector[Vector[T]]):
  def this(len: Int, filling: T) = this(Vector.tabulate(len, 2) { (row, col) => filling } )



val s1: Vector[Int] = Vector(1, 2, 3)
val s2: Vector[Int] = Vector(3, 4, 5)

val t: Matrix[Int] = Matrix(Vector(s1, s2))