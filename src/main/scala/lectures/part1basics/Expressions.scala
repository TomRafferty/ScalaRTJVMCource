package part1basics

object Expressions extends App {

  val x = 1 + 2 //expression - compiler can infer the type
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= .... side effects (they only work with variables)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  println(if(aCondition) 5 else 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //Don't use loops as they are imperative code
  //everything in scala is an expression

  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue) // ()

  // side effects: println(), while, reassigning var

  // code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }


  //pausing and answering questions...

  // 1. difference between "hello world" and println("hello world")?
  // I think the difference is that "hello world" is a value of type string
  // on the other hand println("hello world") is an expression and the value would just be ()/void/unit

  // 2. result of:
  val someValue = {
    2 < 3
  }
  // someValue: Boolean = true

  // 3. result of:
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // someOtherValue: Int = 42


  //pretty much got this bang on and even though
  //it's pretty basic I felt quite happy with that
  //as trivia such as the first question is something
  //I'd typically not know
}
