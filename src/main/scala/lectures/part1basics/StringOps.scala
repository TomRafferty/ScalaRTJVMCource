package part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString: String = "45"
  val aNumber: Int = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  //string interpolators

  //s-interpolators
  //did this one already in some of the previous exercises
  val name: String = "Tom"
  val age: Int = 25
  val greeting: String = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting: String = s"Hello, my name is $name and I will be turning ${age + 1}"
  println(anotherGreeting)

  //f-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat ${speed % 2.2f} burgers per minute"
  println(myth)
  //all I really understood from that was that the f-interpolator can use type formats
  //I don't understand why we have "${speed % 2.2f}" in my mind it seems like the 2.2 should
  //override the 1.2f speed value - just got confusion and wasn't really explained

  //raw-interpolator
  println(raw"this is a \n newline") //no new line created because everything is taken as a string literal
  val escaped = "this is a \n newline"
  println(raw"$escaped")
  //this works because the expression is evaluated then placed into the raw"" - it is only
  //within the raw"" that everything is taken as a string literal
}
