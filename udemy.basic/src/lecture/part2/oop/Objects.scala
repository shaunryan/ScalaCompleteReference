package lecture.part2.oop

object Objects extends App{

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY "static"
  // COMPANION model - object and class companions
  object Person {
    // class-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def from(mother: Person, father: Person) : Person = new Person("Bobby")
    // or better!
    def apply(mother: Person, father: Person) : Person = new Person("Bobby")
  }
  class Person(val name:String) {
    // instance-level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  val person1 = Person
  val person2 = Person
  // person1 and person2 are pointers to the same singleton instance Person
  // scala object = SINGLE INSTANCE = IS A SINGLETON by definition!
  // Great for factory patterns
  println(person1 == person2)

  // multiple instance can be created with a class companion
  val john = new Person("John")
  val mary = new Person("Mary")
  println(mary == mary)

  val bobby = Person.from(john, mary)
  val bobbyBetter = Person.apply(john, mary)
  // calls the factory apply by default.
  val bobbyBetterStill = Person(john, mary)

  // Scala Application = scala object with
  // def main(args: Array[String]): Unit
  // equivalent to
  // extends App
}
