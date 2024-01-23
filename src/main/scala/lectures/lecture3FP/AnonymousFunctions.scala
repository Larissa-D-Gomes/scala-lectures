/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-22
 */
package lectures.lecture3FP

object AnonymousFunctions extends App {
  // OO way of defining an anonymous function
  //  val doubler = new Function1[Int, Int] {
  //    override def apply(v1: Int): Int = v1 * 2
  //  }

  // Syntax sugar (Lambda expression)
  val doubler: Int => Int = (x: Int) => x * 2

  // Multiple params
  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y

  // No param
  val justDoSomething: () => Int = () => 3

  // Lambda functions must be called with ()
  println(justDoSomething)
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = {(str: String) =>
    str.toString
  }

  val incrementer: Int => Int = _ + 1
  println(incrementer(5))

  val randomFunction = (x: Int) => (y: Int) => x + y
  println(randomFunction(2)(7))
}
