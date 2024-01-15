/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-12
 */
package lectures.lecture1Basics

object StringOps extends App {

  val str: String = "Hello! How are you doing?"
  println(str.charAt(1))
  println(str.substring(7, 10))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  // String interpolators

  // S-interpolators
  val name = "Larissa"
  val age = 22
  val greeting = s"Hello, my name is $name and I am $age years old."
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(greeting)
  println(anotherGreeting)

  // F-interpolators -> defines a string format
  val speed = 0.5f
  val mith = f"$name can run $speed%2.2f miles per minute."
  println(mith)

  // Raw-interpolators
  println(raw"This is a \n newline")
}
