/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-16
 */
package lectures.lecture2OOP

object Inheritance extends App {
  class Animal {
    val creatureType = "Wild"
    def eat = println("Eating...")
  }

  // Single class Inheritance
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat()
  cat.crunch

  // Constructors
  class Person(val name: String, val age: Int)
  class Adult(name: String, age: Int, val idCard: String) extends Person(name, age)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "Domestic"
    override def eat = {
      super.eat
      println("(Dog) eating")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Preventing override
  // 1 - use the key word final on member
  // 2 - use the key word final on the entire class
  // 3 - Seal the class -> prevent extension in other files (key word sealed)
}
