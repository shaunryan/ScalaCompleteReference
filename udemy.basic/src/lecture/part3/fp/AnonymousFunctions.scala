package lecture.part3.fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  // either declare the type of the parameter
  val doubler1 = (x: Int) => x * 2
  // or the type of the function
  val doubler2: Int => Int = x => x * 2

  // multiple parameters in a lambda - must use parenthesis
  val adder = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething1 = () => 3
  val justDoSomething2: () => Int = () => 3

  // be careful
  println(justDoSomething1) // the function itself
  println(justDoSomething2) // call

  // curly braces with lambdas
  val stringToInt = { (str:String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1  // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (x,y) => x + y


  /*
  Exercises
    1. MyList: replace all FunctionX calls with lambdas
    2. Rewrite the curried adder as an anonymous (lambda) function
   */



}
