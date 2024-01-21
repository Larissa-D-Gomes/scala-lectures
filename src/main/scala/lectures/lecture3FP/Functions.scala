/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-21
 */
package lectures.lecture3FP

object Functions extends App {
  // Objective: Functions -> First class elements
  // Problem: OOP world -> everything is a class
  
  val doubler = new MyFunction[Int, Int] {
    def apply(element: Int): Int = element * 2
  }
  // Doubler is a class that is called and acts like a function
  println(doubler(2))
  
  val stringToIntConverter = new MyFunction[String, Int] {
    def apply(element: String): Int = element.toInt
  }
  println(stringToIntConverter("22") + 5)
  
  // ALL SCALA FUNCTIONS ARE OBJECTS
  val stringConcat = new Function2[String, String, String] {
    override def apply(element1: String, element2: String): String = element1 + element2
  }
  println(stringConcat("String1", "String2"))
  
  val getRandomFunction = new Function1[Int, Function1[Int, Int]] {
    def apply(x: Int): Function1[Int, Int] = {
      new Function1[Int, Int] {
        def apply(y: Int): Int = x + y
      }
    }
  }
  
  val randomFunc1 = getRandomFunction(2)
  println(randomFunc1(4))
}

trait MyFunction [A, B] {
  def apply(element: A): B 
} 