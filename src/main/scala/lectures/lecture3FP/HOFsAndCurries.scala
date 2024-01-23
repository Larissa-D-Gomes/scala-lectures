/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-22
 */
package lectures.lecture3FP

object HOFsAndCurries extends App {
  // Functions that receive functions as params or return functions are Higher Order Functions (HOF)

  // Example a function that applies another function n times over a given value
  def nTimes(x: Int, n: Int, func: (Int => Int)): Int = {
      if(n <= 0) x
      else nTimes(func(x), n-1, func)
  }

  val plusOne = (x: Int) => x + 1

  println(nTimes(1, 10, plusOne))

  def nTimesBetter(n: Int, func: (Int => Int)): (Int => Int) = {
     if(n <= 0) (x: Int) => x
     else (x: Int) => nTimesBetter(n - 1, func)(func(x))
  }

  val plusTen = (x: Int) => x + 10
  println(nTimesBetter(10, plusTen)(1))
}
