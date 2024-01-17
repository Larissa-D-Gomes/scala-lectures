/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-15
 */
package lectures.lecture2OOP

object Objects extends App {
  // Scala does not have class level functionality ("Static")

  object Person { // Type + only instance
    // static/class-level functionality
    val N_HEART = 1
    def canFly: Boolean = false
    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bob")
  }
  // Class + Object Person = companions
  class Person(val name: String) {
    // Instance-level functionality
  }

  println(Person.N_HEART)
  println(Person.canFly)

  // Scala object is a singleton instance
  val mary = new Person("Mary")
  val john = new Person("John")
  val bob = Person(mary, john)
  println(bob.name)

  // Scala applications = Scala object with
  // def main(args: array[String]): Unit

}
