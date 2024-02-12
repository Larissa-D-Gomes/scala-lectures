package exercises

abstract class Maybe [+T] {
  def map[B](f: T => B): Maybe[B]
  def filter(f: T => Boolean): Maybe[T]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot

  def filter(f: Nothing => Boolean): Maybe[Nothing] = MaybeNot

  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = new Just(f(value))

  def filter(f: T => Boolean): Maybe[T] = {
    if(f(value)) new Just(value)
    else MaybeNot
  }

  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
}

object MaybeTest extends App {
  val just2 = new Just[Int](2)
  println(just2.map(_ + 1))
  println(just2.filter(_ % 2 == 1))
  println(just2.filter(_ % 2 == 0))
  println(just2.flatMap(x => Just(x == 1)))
}
