package lectures.lecture2OOP

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(this.name + " (" + nickname + ")", this.favoriteMovie)

    def unary_! : String = "???"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(subject: String): String = s"$name learns $subject"

    def learnsScala: String = this learns "Scala"

    def apply(numberOfTimes: Int): String = s"$name watched $favoriteMovie $numberOfTimes times."
  }

  val mary = new Person("Mary", "Inception", 23)
  println(mary.likes("Inception"))

  // (syntactic sugar)
  // Infix Notation or Operator Notation -> Only works with methods with a single parameter
  println(mary likes "Inception")

  // Scala "operators" -> All operators are methods
  val tom = new Person("Tom", "The Batman")
  println(mary + tom)
  println(1.+(2))

  // Prefix notation -> unary operator
  val x = -1
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  println(!mary)

  // Postfix notation -> methods that do not receive any parameters
  println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary())

  println((mary + "May").name)
  println((+mary).age)
  println(mary learns "C++")
  println(mary learnsScala)
  println(mary(5))
}


