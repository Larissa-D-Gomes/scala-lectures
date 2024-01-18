/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-17
 */

package lectures.lecture2OOP

object Generics extends App {
  class MyList[+A] {
    // Generic type A
    def add[B >: A] (element: B): MyList[B] = ???
  }

  class MyMap[Key, Value] {

  }

  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = new MyList[A]
  }

  val emptyListOfInt = MyList.empty[Int]

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalCovariantList: CovariantList[Animal] = new CovariantList[Cat]

  // Invariance
  class InvarianceList[A]
  val animalInvarianceListList: InvarianceList[Animal] = new InvarianceList[Animal]

  // Contravariance
  class ContravariantList[-A]
  val animalContravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // Bounded types
  class Cage[A <: Animal] (val animal: Animal) // Cage only accepts subtypes of Animal
  val cage = new Cage(new Dog)

  class AnotherCage[A >: Animal](val animal: Animal) // Cage only accepts supertypes of Animal

}
