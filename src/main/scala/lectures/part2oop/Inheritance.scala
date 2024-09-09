package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val creatureType = "wild"
//    protected def eat: Unit = println("nom nom nom") //protected allowed in subclass, private only allowed within that declaration
//    final def eat = println("nom nom nom") //this would stop any overriding from taking place in extending classes
    def eat = println("nom nom nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat= {
      super.eat //will use super/parent class method
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat //uses the most overriden version


  //preventing overrides:
  /*

  1. using a <final> on member
  2. using a <final> on an entire class
  3. sealing a class - can extend classes in this file but prevents extension in other files

  */
}
