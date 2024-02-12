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
  def foreach(f: (A => Unit)): Unit
  def sort(f: (x: A, y: A) => Int): MyList[A]
  def zipWith[B, C](f: (x: A, y: B) => C, anotherList: MyList[B]): MyList[C]
  def fold[B](f: (x: A, y: B) => B, startIndex: B): B
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
  def foreach(f: (Nothing => Unit)): Unit = null
  def sort(f: (x: Nothing, y: Nothing) => Int): MyList[Nothing] = EmptyList
  def zipWith[B, C](f: (Nothing, B) => C, anotherList: MyList[B]): MyList[C] = {
    if(anotherList.isEmpty) EmptyList
    else throw new RuntimeException()
  }
  def fold[B](f: (x: Nothing, y: B) => B, start: B): B = start
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

  def foreach(f: (A => Unit)): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (x: A, y: A) => Int): MyList[A] = {

    def insert(element: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty) new Cons(element, EmptyList)
      else if (compare(element, sortedList.head) < 0) new Cons(element, sortedList)
      else new Cons(sortedList.head, insert(element, sortedList.tail))
    }
    
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](f: (x: A, y: B) => C, anotherList: MyList[B]): MyList[C] = {
    if(anotherList.isEmpty) new RuntimeException()
    new Cons(f(h, anotherList.head),  t.zipWith(f, anotherList.tail))
  }

  def fold[B](f: (x: A, y: B) => B, startIndex: B): B = {
    t.fold(f, f(h, startIndex))
  }
}

object ListTest extends App {
  val evenPredicate = (element: Int) => element % 2 == 1
  val compareInt = (x: Int, y: Int) => x - y
  val zipFuncInt = (x: Int, y: Int) => "\n(" + y + ")" + x
  val sumInt = (x: Int, y: Int) => x + y

  val listOfIntegers = new Cons[Int](4, new Cons(1, new Cons(33, new Cons(0, EmptyList))))
  val listOfIntegers2 = new Cons[Int](0, new Cons(1, new Cons(2, new Cons(3, EmptyList))))
  println(listOfIntegers.sort(compareInt).toString)
  println(listOfIntegers.sort(compareInt).zipWith(zipFuncInt, listOfIntegers2).toString)
  println(listOfIntegers2.fold(sumInt, 1))

  val numbers = new Cons[Int](1, new Cons(2, new Cons(3, new Cons(4, EmptyList))))
  val char = new Cons[String]("a", new Cons("b", new Cons("c", new Cons("d", EmptyList))))

  var combination = for {
    x <- numbers
    y <- char
  } yield x + y

  println(combination)

}

//object EvenPredicate extends Predicate[Int] {
//  def test(testValue: Int): Boolean = testValue % 2 == 1
//}

//object StringToIntTransformer extends Transformer[String, Int] {
//  def transformation(value: String): Int = value.toInt
//}

