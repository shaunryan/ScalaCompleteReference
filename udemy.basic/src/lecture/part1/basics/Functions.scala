package lecture.part1.basics

object Functions extends App{

  def aFunction(a:String, b:Int):String = {
    s"$a $b"
  }
  println(aFunction("a", 3))

  def aParameterlessFunction(): Int = 42
  // doesn't need brackets
  println(aParameterlessFunction)
  println(aParameterlessFunction())

  // when you need loops - use recursion
  // the return type is needed since the compiler cannot figure out the
  // recursive type on it's own
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    // auxiliary function, function in a function
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

    /*
      1. a greeting function (name, age) => "Hi, my name is $name and I am $age years old."
      2. Factorial function 1 * 2 * 3 * .. * n
      3. A fibonacci function
        f(1) = 1
        f(f) = 1
        f(n) = f(n - 1) + f(n - 2_
      4. Test if a number is prime
     */

    def greeting(name:String, age:Int ): Unit = {
      println(s"Hi, my name is $name and I am $age years old.")
    }




}
