package lectures.part2oop

import lectures.part2oop.Generics.MyList

import scala.language.postfixOps

//my initial implementation
//abstract class MyList {
//  /*
//  head = first element of the list
//  tail = remainder of the list
//  isEmpty = is this list empty
//  add(Int) => new list with this element added
//  toString => returns a string representation of the list
//   */
//  val elements: List[Int]
//  def head: Int
//  def tail: List[Int]
//  def isEmpty: Boolean
//  def add(n: Int): List[Int]
//  def toString: String
//}

trait MyPredicate[-T]{
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem: A): B
}

//the correct implementation:
abstract class MyList[+A]{
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  //polymorphic call
  override def toString: String = "["+ printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
}

//how it was intended to be solved (again, I got a bit confused on what I was meant to deliver here)
object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

}// ??? will throw an exception but allows us to code on and implement later

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = new Cons(n, this)
  def printElements: String = if(t.isEmpty) "" + h else h + " " + t.printElements

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  //polymorphic call
  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}

/*
1. Generic trait MyPredicate[-T] - have a small method to test if [T] passes a condition
  - little method test(T) => Boolean

2. Generic trait MyTransformer[-A, B] - method to convert type A to type B
  - transform(A) => B

3. implement the following functions on MyList:
  - map(MyTransformer) => MyList
  - filter(MyPredicate) => MyList
  - flatMap(MyTransformer from A to MyList[B]) => MyList[B]

Examples:
  class EvenPredicate extends MyPredicate[Int] => even or not (Boolean)
  class StringToIntTransformer extends MyTransformer[String, Int]

should work like:

  [1,2,3].map(TransformerThatDoublesInt) = [2,4,6]
  [1,2,3,4].filter(PredicateIsEven) = [2,4]
  [1,2,3].flatMap(Transform(n => [n, n+1])) => [1,2,2,3,3,4]
 */