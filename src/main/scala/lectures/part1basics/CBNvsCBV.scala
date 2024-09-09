package part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println(s"by value: $x") //x will be evaluated once for this function
    println(s"by value: $x")
  }

  // "=>" tells the compiler this will be called by name
  def calledByName(x: => Long): Unit = {
    println(s"by name: $x") //x will be evaluated each time it is used for this function
    println(s"by name: $x")
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinite(), 34) //stack overflow
  printFirst(34, infinite())
  //this doesn't crash because the by name functionality in this case means that infinite() is never called
}

//thoughts:
/*
I didn't know about this functionality at all so this was super useful
*/