package part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1) //didn't expect recursion this early
  }
  println(aRepeatedFunction("hello", 3))

  //when loops are needed use recursion

  def aFucntionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {

    def aSmallerfunction(a: Int, b: Int): Int = a + b
    aSmallerfunction(n, n-1)

  }
  println("EXERCISES")
  // 1. a greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def greetingFunction(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old"
  println(greetingFunction("Tom", 25))
  // 2. a factorial function 1 * 2 * 3 * .. * n
  def factorialFucntion(n: Int, count: Int = 1): Unit = {
    if (count == n) println(count * n) else {
      println(count * n)
      factorialFucntion(n, (count + 1))
    }
  }
  factorialFucntion(5)
  // 3. a fibonacci function
  /*    f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
  */
  // 4. function that tests if a number is prime
  def fibonacciFunction(n: Int): Int = { //I found this one online, couldn't figure it out myself :-(
    if(n <= 1) n else {
      fibonacciFunction(n - 1) + fibonacciFunction(n - 2)
    }
  }
  println(fibonacciFunction(10))

  //reflections on my work:
  /*
  * my greeting function is fine, simple
  *
  * I overcomplicated my factorial function
  *
  * I first missed the prime function but honestly watching over the explanation of it was a bit confusing (this may just be fatigue)
  * */

}
