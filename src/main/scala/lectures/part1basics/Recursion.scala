package part1basics

import part1basics.Functions.fibonacciFunction

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println(s"computing factorial of $n - I first need factorial of ${n-1}")
      val result = n * factorial(n - 1)
      println(s"computed factorial of $n")
      result
    }
  }

  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    //this is tail recursive as the recursion happens at the end making for a more
    //efficient recursion and allowing for more effective use of JVM memory
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(n,1)
  }

  println("EXERCISES")
  /*
  *
  * 1. concatenate a string n times
  * 2. isPrime function tail rec
  * 3. fibonacci tail rec
  *
  * */
  @tailrec
  def concatStringNTimes(s: String, n: Int, currentResult: String = ""): String = {
    if (n == 1) s+currentResult else concatStringNTimes(s, n-1, currentResult+s)
  }
  println(concatStringNTimes("hello",3))

//  @tailrec
  def isPrime(n: Int, count: Int = 2, limit: Int): Boolean = {
    def primeCheck(num: Int, divider: Int): Boolean = {
      num % divider == 0
    }
    if (count == limit){
      primeCheck(n, count)
    }else{
      if (!primeCheck(n, count)) false
      else isPrime(n, count+1, limit)
    }
  }


  println(isPrime(61, limit = 350)) //should be true
  println(isPrime(199, limit = 350)) //should be true
  println(isPrime(311, limit = 350)) //should be true
  println(isPrime(10, limit = 350)) //should be false
  println(isPrime(305, limit = 350)) //should be true

  //this fails, why can't I get something like prime numbers down. I should really be able to do this.

//  def isPrimeAgain(n : Int): Boolean = {
//    /*
//    take a number and a limit
//    check all numbers before that limit against the number given with n%count==0
//
//    if false, exit loop
//    if limit hit, return result
//    else, run again
//    */
//  }

  //spending too much time on this now so will move on



  //code along with the video
  println("Code along ----- not my code")
  def isPrimeExample(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailrec(n / 2, true)

  }
  println(isPrimeExample(2003))
  println(isPrimeExample(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) //should be 21
}

//thoughts at the end of that are my confidence is knocked - I struggled a lot with that and given how long
//I've been doing this I don't think that should be the case.
