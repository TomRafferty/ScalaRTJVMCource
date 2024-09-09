package lectures.part2oop

object Objects extends App {

  object Person {//type + it's only instance
    //"static"/"class"-level functionality
    val N_EYES = 2
    def canFly = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    //instance-level functionality
  }
  //companions


  println(Person.N_EYES)
  println(Person.canFly)

  //scala object is a singleton instance
  val mary = Person
  val john = Person
  println(mary == john) //true

  val maryNew = new Person("Mary")
  val johnNew = new Person("John")
  println(maryNew == johnNew) //false - they are instances of the type and are unique

  val bobbie = Person(maryNew, johnNew) //Person.apply(maryNew, johnNew)

  //scala applications - scala object with
  //def main(args: Array[String]): Unit

}
