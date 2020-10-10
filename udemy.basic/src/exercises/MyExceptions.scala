package exercises

/*
  1. Crash your program with an OutOfMemoryError
  2. Crash with SOError
  3. PocketCalculator
    - add(x,y)
    - subtract(x,y)
    - multiply(x,y)
    - divide(x,y)

    Throw
      - OverflowException if add(x,y) exceeds Int.MAX_VALUE
      - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
      - MatchCalculationWithException for division by 0

 */

object MyExceptions extends App {

  // OOM - out of memory
  val array = Array.ofDim(Int.MaxValue)

  // SO - stack overflow
  def infinite:Int = 1 + infinite
  val notLimit = infinite

  object PocketCalculator {

    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y==0) throw new MathCalculationException
      else x/y
    }

    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by 0")

  }

}
