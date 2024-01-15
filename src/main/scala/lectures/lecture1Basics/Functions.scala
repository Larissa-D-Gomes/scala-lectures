/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-09
 */
package lectures.lecture1Basics

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hi", 3))

  def recursiveFunction (stringVal: String, n: Int): String = {
    if(n == 1) stringVal
    else stringVal + " " + recursiveFunction(stringVal, n-1)
  }

  println(recursiveFunction("Hi", 3))

  def greeting (name: String, age: Int): Unit = {
    println("Hi! My name is " + name + " and I'm " + age + " years old." )
  }

  greeting("Larissa", 22)

  def factorial(n: Int): Int = {
    if(n > 1) n * factorial(n-1)
    else n
  }

  println("Factorial = " + factorial(4))

  def fibonacci(n: Int): Int = {
    if (n > 2) fibonacci(n - 1) + fibonacci(n - 2)
    else 1
  }

  println("Fibonacci = " + fibonacci(4))

  def isPrime(n: Int): Boolean = {
    def isPrimeRecursive(divider: Int): Boolean = {
      if(divider >= n) true
      else if(n % divider == 0) false
      else isPrimeRecursive(divider + 1)
    }
    if(n == 1) false
    else isPrimeRecursive(2)
  }

  println(isPrime(13))

}
