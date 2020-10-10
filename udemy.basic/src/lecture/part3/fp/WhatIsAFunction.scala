package lecture.part3.fp

class WhatIsAFunction {

  /* ******************************************************
  Dream: Use functions as a first class elements]")
  Problem: oop")
  ****************************************************** */

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // but we can use it like a pure function type
  println(doubler(2))

  // function types = Function[A, B]
  // function type supported by scala
  // support function 1 to 22

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3")+4)

  // or with syntactic sugar
  val adder: ((Int, Int) => Int) = new ((Int, Int) => Int) {
    override def apply(a: Int, b: Int): Int = a + b
  }
  // same as
  val adder2 = new ((Int, Int) => Int) {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function0 example
  val inc = new Function0[Int] {
    override def apply(): Int = 0
  }
  // or
  val inc1 = new (() => Int) {
    override def apply(): Int = 0
  }

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /* ******************************************************
  Exercises

  1. a function that takes 2 strings and concatenates them
  2. Transform the MyPredicate and MyTransformer into function types
  3. define a function that takes an int and returns another function which takes int and returns and int
    - what is the type of this function
    - how to do it

  ****************************************************** */

  def concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenator("Hello ", "World"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder : Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3) // returns a function to adder 3
  println(adder3(4)) // a function that adds 3 to 4
  println(superAdder(3)(4)) //or just call together - called a curried function, can take multiple parameter lists.
}


// the horrible OOP way - function simulation
class Action{
  def execute(element: Int): String = ???
}

// or at most what OO functional can do
trait ActionT[A, B]{
  def execute(element: A): B
}

// scala functional way
trait MyFunction[A, B]{
  def apply(element: A): B
}