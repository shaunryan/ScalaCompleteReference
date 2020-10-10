package lecture.part2.oop

object OOBasics extends App {

  val person = new Person("John", 36)

  println(person.age)
  person.greet("Daniel")
  person.greet()

  val counter = new Counter

  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(3).print
}

//class Person(name: String, age:Int) //constructor
// class parameters are not fields, add the val in order to make them fields

//constructor
class Person(val name: String, val age:Int = 0)
{
  //body
  val x = 2 // can have expressions
  println(1 +3)

  // this is needed because the method parameter name clashes
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // here it will default to the class name and this is not needed.
  def greet(): Unit = println(s"Hi, I am ${name}")

  // overloading constructors, the limitation is that they have no body
  // the can only default parameters, which can easily be done on the primary
  // signature anyway
  def this(name: String) = this(name, 0)
  def this() = this("John doe")
}

class Counter(val count: Int = 0)
{
  def inc = {
    println("incrementing")
    new Counter(count+1)
  } // re-instantiate because count is immutable

  def dec = {
    println("decrementing")
    new Counter(count-1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1) //recursively increments by 1 until done
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)


}

