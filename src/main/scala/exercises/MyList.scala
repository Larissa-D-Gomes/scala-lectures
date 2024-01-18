/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-17
 */
package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](value: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList [Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing](value: B): MyList[B] = new Cons(value, EmptyList)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](value: B): MyList[B] = new Cons(value, this)
  def printElements: String =
    if(tail.isEmpty) "" + h
    else "" + h + ", " + t.printElements
}

object ListTest extends App {
  val listOfIntegers = new Cons[Int](1, new Cons(2, new Cons(3, EmptyList)))
  println(listOfIntegers.tail.head)
  println(listOfIntegers.add(4).head)
  println(listOfIntegers.isEmpty)
  println(listOfIntegers.toString)
}