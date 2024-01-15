/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-09
 */
package lectures.lecture1Basics

object VariablesValuesTypes extends App {
  // Vals are immutable (constant values)
  val x: Int = 42
  println(x)

  // The compiler can infer types
  val y = "hi"
  println(y)

  // Var are mutable
  var z = 4
  println(z)
  z = x
  println(z)
}
