package lectures.part2oop

object AbstractDataTypes extends App{

  //abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch") //we don't need to override here because there was no implementation of the method
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "Croc"
    def eat: Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a $creatureType and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  /*
  1. traits do not have constructor parameters (possible in scala 3)
  2. you can only extend one class but you can mix in multiple traits
  3. traits = behavior, abstract class = thing
   */
}
