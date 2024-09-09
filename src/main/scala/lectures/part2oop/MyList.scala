/*
package lectures.part2oop

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

//the correct implementation:
abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(n: Int): MyList
  def toString: String
}

//how it was intended to be solved (again, I got a bit confused on what I was meant to deliver here)
object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n: Int): MyList = new Cons(n, Empty)
}// ??? will throw an exception but allows us to code on and implement later

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(n: Int): MyList = new Cons(n, this)
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
}

/*
class justAList(override val elements: List[Int]) extends MyList {
  //as I'm writing this I'm wondering what the point of doing this is or if I've understood the task wrong :/
  //so to feel like I did something I added some primitive exception handling
  def head: Int = if(!isEmpty) elements.head else sillyGoose
  def tail: List[Int] = if(!isEmpty) elements.tail else sillyGoose
  def isEmpty: Boolean = elements.isEmpty
  def add(n: Int): List[Int] = elements.appended(n)
  override def toString: String = elements.toString

  private def sillyGoose = throw new Exception("The list is empty you silly goose")
}

object Main {
  def main(args: Array[String]): Unit = {

    val newList: justAList = new justAList(List(1,2,3,4,5))
    val emptyList: justAList = new justAList(List())

    //tests / prints here:
    println("tests on newList")
    println(newList head)
    println(newList tail)
    println(newList isEmpty)
    println(newList.add(6))
    println(newList toString)
    println("-------------")

    println("tests on emptyList")
    println(emptyList isEmpty)
    println(emptyList.add(6))
    println(emptyList toString)
    //throw exception:
    println(emptyList head)
    println(emptyList tail)

  }
}
 */


 */