package part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  //this is not recommended but using semi-colons allows for this
  val aString: String = "hello"; val anotherString: String = "world"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 1234
  val aLong: Long = 928639463
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.13

  //variables
  var aVariable = 4
  aVariable = 5 //side effects

}
