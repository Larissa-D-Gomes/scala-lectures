/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-09
 */

package lectures.lecture1Basics

object Expressions extends App {
  var x = 1 + 2 // Expression

  // Instructions (Something to do) vs Expressions (Something that contains a value)
  // Everything in scala is an expression
  // If expression
  val condition = false
  val conditionedVal = if(condition) 5 else 3
  println(conditionedVal)

  // All side effects turn into a unity
  var weirdValue = (x = 1) // Unit type -> not a meaningful value
  // Side effects examples: println, while, reassigning of vars

  // Code blocks -> special kinds of expressions
  val codeBlock = {
    val y = 2
    val z = y + 1
    // The value of the block is the value of the last expression
    if(y > 2) "Hello" else "Hi"
  }
  println(codeBlock)
}
