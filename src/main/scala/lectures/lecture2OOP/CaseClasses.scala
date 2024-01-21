/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-20
 */

package lectures.lecture2OOP

object CaseClasses extends App {

  case class Person(name: String, age: Int)
  val jim = new Person("Jim", 28)
  // With the key word case:
  // 1. Class parameters are promoted to fields
  println(jim.name)

  // 2. Sensible toString method
  println(jim)

  // 3. Equals and hashcode implemented OOTB
  val jim2 = new Person("Jim", 28)
  println(jim == jim2)

  // 4. Handy copy methods
  val jim3 = jim.copy(age = 29)
  println(jim3)

  // 5. Companion objects
  val person = Person
  val Mary = Person("Mary", 32)

  // 6. CCs are serializable

  // 7. CCs have extractor patterns -> CCs can be used in PATTERN MATCHING
}
