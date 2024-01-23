/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-17
 */
package exercises

import lectures.lecture3FP.MyFunction

import javax.swing.text.StyledEditorKit.BoldAction
import scala.annotation.tailrec

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](value: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: A => B): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def ++[B >: A](anotherList: MyList[B]): MyList[B]
}

case object EmptyList extends MyList [Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing](value: B): MyList[B] = new Cons(value, EmptyList)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = EmptyList
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList
  def ++[A](anotherList: MyList[A]): MyList[A] = anotherList

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](value: B): MyList[B] = new Cons(value, this)
  def printElements: String =
    if(tail.isEmpty) "" + h
    else "" + h + ", " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def map[B](transformer: A => B): MyList[B] = new Cons[B](transformer(h), t.map(transformer))

  def ++[B >: A](anotherList: MyList[B]): MyList[B] = {
    new Cons[B](h, t ++ anotherList)
  }

  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
}

//trait Predicate[-T] {
//  def test(testValue: T): Boolean
//}
//
//trait Transformer[-A, B] {
//  def transformation(value: A): B
//}

object ListTest extends App {
  val evenPredicate = (element: Int) => element % 2 == 1

  val listOfIntegers = new Cons[Int](1, new Cons(2, new Cons(3, new Cons(4, EmptyList))))
  println(listOfIntegers.toString)
  println(listOfIntegers.filter(evenPredicate))

  val listOfString = new Cons[String]("10", new Cons("12", new Cons("23", new Cons("32", EmptyList))))
  val listOfIntegers2 = listOfString.map((value: String) => value.toInt)
  
  val listOfIntegers3 = listOfIntegers ++ listOfIntegers2
  println(listOfIntegers3)

  val listOfIntegers4 = listOfIntegers3.flatMap((value: Int) => new Cons[Int](value, new Cons[Int](value + 1, EmptyList)))

  println(listOfIntegers4)
}

//object EvenPredicate extends Predicate[Int] {
//  def test(testValue: Int): Boolean = testValue % 2 == 1
//}

//object StringToIntTransformer extends Transformer[String, Int] {
//  def transformation(value: String): Int = value.toInt
//}

