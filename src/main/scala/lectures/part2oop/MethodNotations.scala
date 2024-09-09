package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favouriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie)

    def unary_! : String = s"$name what the heck?!"
    def unary_+ : Person = new Person(name, favouriteMovie, age+1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched their favourite movie $favouriteMovie $n times"

    def learns(skill: String): String = s"$name learns $skill"
    def learnsScala: String = learns("Scala")
  }

  val mary: Person = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //these two are equivalent
  //this is call infix/operator notation
  //this only works if the method has one parameter - <Object method parameter> (syntactic sugar)

  //"operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom) //this freedom of naming is pretty wild
  //this works because these symbols are created in the same way when using them normally i.e:
  println(1.+(2))

  //All operators are methods

  //Akka actors have ! ?

  //prefix notation
  val x = -1
  val y = 1.unary_- //these two are the same
  //unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //equivalent

  /*
  1. overload the + operator
      mary + "The Rockstar" => new person "Mary (The Rockstar)"

  2. add age to Person class
     add a unary + operator => new Person with the age + 1
     +mary => mary with the age incrementer  (resembles ++)

  3. add "learns" method in the Person class => "Mary learns Scala"
     add learnsScala method, calls learns method with "Scala"
     use in postfix notation

  4.overload the apply method
    mary.apply(2) => "Mary watched her favourite movie Inception 2 times"

   */

  //1.
  val bob: Person = new Person("Bob", "Endgame")
  println((bob + "The Bobstar").name)

  //could have been achieved with:
  println((bob + "The Bobstar")()) //nothing wrong just different to how the example was in the video

  //2.
  val bobOlder: Person = +bob
  println(bobOlder.age) //made age a val so that I could access here to test

  //3.
  println(bob learnsScala)

  //4.
  println(bob.apply(50))
}
