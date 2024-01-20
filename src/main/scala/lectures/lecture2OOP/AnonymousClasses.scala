/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-18
 */
package lectures.lecture2OOP

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }


  // Anonymous Class
  // class AnonymousClasses$$anon$1 extends Animal {
  //   def eat = println("Eating...")
  // }

  val animal = new Animal {
    def eat = println("Eating...")
  }
  println(animal.eat)

  class Person(name: String) {
    def sayHi = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi = println("Hi, my name is Jim. How can I help?")
  }
  jim.sayHi
}
