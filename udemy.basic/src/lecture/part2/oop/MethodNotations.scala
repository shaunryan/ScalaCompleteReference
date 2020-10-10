package lecture.part2.oop

object MethodNotations extends App{

  class Person(val name: String, favouriteMovie: String)
  {

    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person:Person): String = s"${this.name} is handing out with ${person.name}"
    def +(person:Person): String = s"${this.name} is handing out with ${person.name}"
    def unary_! : String = s"$name, what the heck?"
             //^ space here is needed or comiler will this it's part of the method name
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie "
  }

  // infix notation
  //***********************************************

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // infix notation, or operator notation; must have a single parameter
  // much like natural language
  println(mary likes "Inception")


  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")

  // hangout acts like an operator
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // operators act like methods, because they are!

  // prefix notation
  //***********************************************
  val x = -1
  val y = 1.unary_- // is equivalent
  // only works with a few operators

  println(!mary)
  println(mary.unary_!)


  // postfix notation
  //***********************************************
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  //***********************************************
  println(mary.apply())
  println(mary()) // mary can be called like a function!
}
