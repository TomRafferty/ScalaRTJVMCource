package lectures.part2oop

object Generics extends App {

  class MyList[+A] { //Lists are usually covariant
    //use the type of A
    def add[B >: A](element: B): MyList[B] = ??? //if to a List[A] I put in a B which is a supertype of A then this List will turn into a List[B], not List[A]
    /*
    example:
    A = Cat
    B = Dog = Animal - i.e it's not a Cat but it's a supertype of Animal
    then we will turn this into a List[B] or List[Animal]
     */

  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //COVARIANCE
  //List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A] //+A means a covariant list
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ? Hard question - would pollute the list as Cat and Dog are not the same type even though they extend the same class
  //adding a Dog to a List[Cat] would transform that type to List[Animal]


  //INVARIANCE
  //this would be an invariance list (every type is in it's own space)
  class InvariantList[A] //without anything like + before or after the type symbol - this is an invariant.
//val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // doesn't work
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] //has to be animal and can't be anything else

  //CONTRAVARIANCE
  //Contravariance (opposite to covariance)
  class ContravariantList[-A] //the '-' signifies a contravariant
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal] //this is replacing a List[Cat] with a List[Animal]
  // Covariance allows us to use Cat in place of Animal because Cat extends Animal

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] //in this case this is better because a Trainer[Animal] covers the Trainer[Cat] as Cat is extended from Animal



  //bounded types
  //upper bounded type of animal
  class Cage[A <: Animal](animal: A) //cage will only accept types which are subtypes of animal
  val cage = new Cage(new Dog)

  class Car
  //val newCage = new Cage[Car](new Car) //in the video intelliJ doesn't complain about this but
  // here it does - either way this is an error because Car is not a subtype of Animal

  //lower bounded type
  class OtherCage[A >: Animal](animal: A) //this means it will only accept the supertype of Animal - nothing that extends it




  //Exercises:
  /*
  1. expand MyList to be generic
  ... so I guess by definition it takes a type as a parameter? Does it not already do that though?
  I'm going to just implement the method (add) that was left as ???

  added - I couldn't figure out the method and I still don't know if that's what I should be working on
  these I've noticed are also concerns in the Q/A section for a lot of people on this course so I don't feel as
  bad for being confused now - just going to code along with the exercise at the end of this one.

  to clarify - he wanted me to expand the MyList class within the MyList file - he didn't say that until the explanation part.
  there is a class and companion object in this file that when following along with him we created here... So my confusion
  was partly that I thought I was supposed to be working on this one in here...
   */
}
