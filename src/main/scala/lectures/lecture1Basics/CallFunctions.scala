/* @author Larissa Gomes
 * @version 0.1
 * @date 2023-01-09
 */
package lectures.lecture1Basics

object CallFunctions extends App{
  def calledByValue(x: Long): Unit = {
    println("By value = " + x)
    println("By value = " + x)
  }

  // The => tells the compiler that the parameter is going to be called by name
  def calledByName(x: => Long): Unit = {
    println("By name = " + x)
    println("By name = " + x)
  }

  // The expression value is evaluated before the function evaluates
  calledByValue(System.nanoTime())
  // The literal expression is passed by parameter
  calledByName(System.nanoTime())
}
