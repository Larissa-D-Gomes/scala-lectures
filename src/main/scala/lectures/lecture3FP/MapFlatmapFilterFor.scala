package lectures.lecture3FP

object MapFlatmapFilterFor extends App {
  // Standard library List
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 1))

  // Filter
  println(list.filter(_ % 2 == 0))

  // FlatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List("a", "b", "c", "d")
  val colors = List("Black", "White")

  // Iterations
  // nˆ2
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)
  // nˆ3
  val combinationsWithColors = numbers.flatMap(n => chars.flatMap(c => colors.map(a => c + n + "-" + a)))
  println(combinationsWithColors)

  // Foreach
  println(list.foreach(println))

  // for-comprehensions
  // The compiler rewrite the expression as a chain of maps and flatMaps
  var forCombinations = for {
    n <- numbers if n % 2 ==0
    c <- chars
    color <- colors
  } yield c + n + "-" + color

  println(forCombinations)

  // syntax overload
  list.map { x =>
    x * 2
  }
}
