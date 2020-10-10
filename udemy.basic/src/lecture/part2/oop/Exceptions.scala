package lecture.part2.oop

object Exceptions extends App {



  val x: String = null
  // println(x.length) //this will crash with a nullpointer exception

  // 1. Throwing exceptions

  // val aWeirdValue: String = throw new NullPointerException
  // perfectly valid because throw returns nothing and nothing is a valid substitute for any other type.
  // throwable classes extend the Throwable class
  // throwable subtypes:
  //    Exceptions - something that went wrong with the app
  //    Error - something that went with the system

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No Int For You!")
    else 42

  try {
    getInt(true)
  } catch {
    case e: NullPointerException => print("caught a Null Pointer exception")
    case e: RuntimeException => print("caught a Runtime exception")
  } finally {
    // code that gets executed no matter what
    println("finally")
  }

  val potentialFail = try {
    getInt(true)
  } catch {
    case e: NullPointerException => 43
    case e: RuntimeException => 44
  } finally {
    // code that gets executed no matter what
    // optional and doesn't influence the return type of the express
    // therefore should only be used for side effects -> logging to something
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  throw exception




}
