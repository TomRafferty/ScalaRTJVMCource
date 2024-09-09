package part1basics

object DefaultArgs extends App {

  //we can use default values in parameters. Useful for when a parameter will usually be the same value
  def trFact(n: Int, acc: Int = 1): Int = {
    if(n <= 1) acc
    else trFact(n-1, n*acc)
  }
  val fact10 = trFact(10, 2) //default args can be overridden

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  //either need all values to have default, or you will need to enter the parameter name if you don't provide values in
  //the right order or leave some missing
  savePicture(width = 800)

}

//thoughts:
/*
I did already know about default args but the refresher was handy
*/