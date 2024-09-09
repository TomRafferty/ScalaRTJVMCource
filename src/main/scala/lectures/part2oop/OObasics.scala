package lectures.part2oop

object OObasics extends App {

  val person = new Person("Tom", 25) //instantiation of class Person
  println(person.age)
  println(person.x)

  person.greet("Tom")


  //tests for the exercises:
  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812) //because this is a new instance - even though it has the same data, it isn't the same object
  val novel = new Novel("Great expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author)) //true
  println(novel.isWrittenBy(impostor)) //false

}

//constructor - every instance of this class must use all constructors
class Person(name: String, val age: Int = 0) {
  //body

  val x = 2 //declarations within a class are fields and can be used as such - see line 7

  println("hello world") //this will appear in the console before the other prints in the object
  //because this class is evaluated upon it's instantiation

  def greet(name: String): Unit = println(s"${this.name} says: \"Hi, $name\"") //while name is not a field in the class - it is accessible within the class using <this>

  //overloading: methods with the same name - This is fine as long as the parameter lists are different between those methods, else the compiler gets confused
  def greet(): Unit = println(s"Hi, I'm $name") //here name is inferred from the class as there are no parameters with the same identifier

  //multiple constructors / overloading constructors
  def this(name: String) = this(name, 0)
  def this() = this("Tom") // I don't like this
  //this above problem ends up being solvable with the use of default params as shown on line 13

}

//class parameters are NOT fields - so <person.name> doesn't work
//however because we use val age (converting to a field) - this allows us to use <person.age>




//EXERCISES:
/*

Novel and Writer classes
  Writer: Firstname, Surname, year of birth
    -Method: fullname (returns first and sur names)

  Novel: Name, year of release, Author(instance of writer)
    -Method: authorAge
    -Method: isWrittenBy(author)
    -Method: copy (new year of release) = new instance of novel


  counter class:
    -receives an int
    -method: current count
    -method: increment/decrement count => return a new counter
    -overload inc/dec method to receive an amount => return a new counter

*/

class Writer(firstname: String, surname: String, val yob: Int) {

  def fullname(): String = s"$firstname $surname"
}

class Novel(name: String, yor: Int, author: Writer) {

  def authorAge(): Int = yor - author.yob

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYor: Int): Novel = new Novel(name, newYor, author)
}


class Counter(n: Int) {

  def currentCount(): Int = n

  def modifyCount(): Counter = new Counter(n)
  //I think I've done this as asked but the task explanation left a little to be desired - I may have just misunderstood though
  def modifyCount(mod: Int): Counter = new Counter(n+mod)

}


/* upon watching the answer code being written:

some things weren't explained very well in terms of what in terms of what I was asked to do
for the exercises - I fixed some of these changes after but honestly, I understand the lesson and I'm not going to
let it cloud the fact that I've gained knowledge from this

a better way to do this I think would be to show the tests or print statements / expected result and let me write
code to match it. Sort of a TDD driven approach because this is leading to crossed wires, and the only way I find
that out is to then spoil the answers for myself unfortunately

*/