/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-11
 */
package lectures.lecture1Basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    }
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1) )
      val result = n * factorial(n - 1) // Scala is going to need a stack frame for each recursive call
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(3))
  // Stack overflow
  // println(factorial(10000))

  // TAIL RECURSION = Use recursive call as the LAST expression
  def anotherFactorial(n: Int): BigInt = {
    @tailrec // Tells the compiler it is supposed to be a tail recursion
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // Recursive call is the last expression of the code path
    }
    factorialHelper(n, 1)
  }

  //println(anotherFactorial(10000))

  def stringConcat(stringVal: String, n: Int): String = {
    @tailrec
    def stringConcatHelper(n: Int, stringAcc: String): String = {
      if(n == 1) stringAcc
      else stringConcatHelper(n - 1, stringVal + " " + stringAcc)
    }

    stringConcatHelper(n, stringVal)
  }

  println(stringConcat("Hi", 2))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeRecursive(divider: Int): Boolean = {
      if (divider >= n) true
      else if (n % divider == 0) false
      else isPrimeRecursive(divider + 1)
    }

    if (n == 1) false
    else isPrimeRecursive(2)
  }

  println(isPrime(3))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, previousResult1: Int, previousResult2: Int): Int = {
      if (i <= 1) previousResult2
      else fibonacciHelper(i - 1, previousResult2, previousResult1 + previousResult2)
    }

    fibonacciHelper(n, 0, 1)
  }

  println(fibonacci(3))
}
