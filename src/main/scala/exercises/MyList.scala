/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-17
 */
package exercises

import scala.annotation.tailrec

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](value: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: Transformer[A, B]): MyList[B]
  def filter(predicate: Predicate[A]): MyList[A]
  def flatMap[B](transformer: Transformer[A, MyList[B]]): MyList[B]
  def ++[B >: A](anotherList: MyList[B]): MyList[B]
}

object EmptyList extends MyList [Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing](value: B): MyList[B] = new Cons(value, EmptyList)
  def printElements: String = ""

  def map[B](transformer: Transformer[Nothing, B]): MyList[B] = EmptyList
  def flatMap[B](transformer: Transformer[Nothing, MyList[B]]): MyList[B] = EmptyList
  def filter(predicate: Predicate[Nothing]): MyList[Nothing] = EmptyList
  def ++[A](anotherList: MyList[A]): MyList[A] = anotherList

}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](value: B): MyList[B] = new Cons(value, this)
  def printElements: String =
    if(tail.isEmpty) "" + h
    else "" + h + ", " + t.printElements

  def filter(predicate: Predicate[A]): MyList[A] = {
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: Transformer[A, B]): MyList[B] = new Cons[B](transformer.transformation(h), t.map(transformer))

  def ++[B >: A](anotherList: MyList[B]): MyList[B] = {
    new Cons[B](h, t ++ anotherList)
  }

  def flatMap[B](transformer: Transformer[A, MyList[B]]): MyList[B] = {
    transformer.transformation(h) ++ t.flatMap(transformer)
  }
}

trait Predicate[-T] {
  def test(testValue: T): Boolean
}

trait Transformer[-A, B] {
  def transformation(value: A): B
}

object ListTest extends App {
  val listOfIntegers = new Cons[Int](1, new Cons(2, new Cons(3, new Cons(4, EmptyList))))
  println(listOfIntegers.toString)
  println(listOfIntegers.filter(EvenPredicate))

  val listOfString = new Cons[String]("10", new Cons("12", new Cons("23", new Cons("32", EmptyList))))
  val listOfIntegers2 = listOfString.map(StringToIntTransformer)
  val listOfIntegers3 = listOfIntegers ++ listOfIntegers2
  println(listOfIntegers3)

  val listOfIntegers4 = listOfIntegers3.flatMap(
    new Transformer[Int, MyList[Int]] {
      def transformation(value: Int):  MyList[Int] = new Cons[Int](value + 1, EmptyList)
    }
  )

  println(listOfIntegers4)
}

object EvenPredicate extends Predicate[Int] {
  def test(testValue: Int): Boolean = testValue % 2 == 1
}

object StringToIntTransformer extends Transformer[String, Int] {
  def transformation(value: String): Int = value.toInt
}

