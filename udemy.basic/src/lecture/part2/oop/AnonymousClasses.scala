package lecture.part2.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahahahaha")
  }

  // note the class name
  println(funnyAnimal.getClass)

  // anonymous classes can be normal class also
  class Person(name: String)
  {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my ame if Jim, how can I be of service?")
  }

  /*
    1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
       (contra-variant in type T, without this it won't compile)

      Has a method that tests whether a value of Type T passes a condition
      Different sub-classes have a different implementation of that method

    2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
       (contra-variant in type T, without this it won't compile)

      Convert type A to type B
      Each sub-class MyTransformer can have a different implementation of that method

    3. MyList: this is a Monad?
      - map(transformer) => returns a new MyList of a different ty[e
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]

      e.g.

      class EvenPredicate extends MyPredicate[Int]
        so test(Int) will return a predicate that indicates whether Int was even or not

      class StringToIntTransformer extends MyTransformer[String, Int]
        transform(String) return Int

      [1, 2, 3].map(n * 2) = [2, 4, 6]                    // transformer
      [1, 2, 3, 4].filter(n % 2) - [2, 4]                 // filter
      [1, 2, 3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]   // concatenated list of sub-list [n, n+1]

   */
}
