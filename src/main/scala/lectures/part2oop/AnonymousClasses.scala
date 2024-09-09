package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahaha")
  }
  //in compilation this looks like:
  /*
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahahaha")
  }
  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */


  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }
  val jim: Person = new Person("jim") {
    override def sayHi: Unit = println(s"Hi, my name is jim, how can I help?")
  }
}
