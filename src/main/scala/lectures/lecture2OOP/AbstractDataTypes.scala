/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-16
 */
package lectures.lecture2OOP

object AbstractDataTypes extends App {
  // Abstract
  abstract class Animal {
    val creatureType: String = "Creature"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"
    def eat: Unit = println("Eating")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    def eat: Unit = println("Eating")
    def eat(animal: Animal): Unit = println(s"Eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // Traits cannot have constructors parameters
  // Multiple traits may be inherited by the same class
  // Trait = Behavior x Abstract Class = Object
}
