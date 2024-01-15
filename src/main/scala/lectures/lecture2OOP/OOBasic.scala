/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-13
 */
package lectures.lecture2OOP

object OOBasic extends App {
  // Test Novel/Writer
  val writer = new Writer("John", "Doe", 1989)
  println(writer.getFullName())

  val novel = new Novel("N1", 2020, writer)
  println(novel.getAuthorAge())
  println(novel.isWrittenBy(writer))

  val novelEd2 = novel.copy(2022)
  println(novel.yearOfRelease)
  println(novelEd2.yearOfRelease)

  // Test Counter
  val counter = new Counter(1)
  println(counter.currentCount())
  val counter2 = counter.decrement(5)
  println(counter2.currentCount())
  val counter3 = counter2.increment()
  println(counter3.currentCount())
}

// Constructor
class Person(val name: String, val age: Int) {
  // body

  // Method
  def greet(name: String): Unit = println(s"Hello, $name! My name is ${this.name}")

  // Overloading
  def greet(): Unit = println(s"Hi! My name is ${this.name}")

  // Multiple constructors
  def this(name: String) = this(name, 0)
}

class Writer(val firstName: String, val surname: String, val year: Integer) {
  def getFullName(): String = firstName + " " + surname
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def getAuthorAge(): Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val value: Int = 0) {
  def currentCount(): Int = value

  // Immutability -> instances are fixed, they cannot be modified inside
  // If we need to change something, we are going to need a new instance
  def increment(): Counter = new Counter(value + 1)
  def increment(amount: Int): Counter = new Counter(value + amount)

  def decrement(): Counter = new Counter(value - 1)
  def decrement(amount: Int): Counter = new Counter(value - amount)

}