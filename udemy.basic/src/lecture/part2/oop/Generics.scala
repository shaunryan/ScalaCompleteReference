package lecture.part2.oop

// NOTE: def ??? : Nothing = throw new NotImplementedError

object Generics extends App{

  // Class Generics
  //***********************************************

  class MyList[+A] {
    // use the type A, works for traits also
//    def add(element: A): MyList[A] = ???
    // errors because if we add Dog to list of Cats what should it do?
//    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog
      Cat & Dog = Animal
     */

  }

  class MyMap[Key, Value]

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Method Generics
  //***********************************************
  object MyList { //objects cannot be type parameterised

    // generics method signature
    def empty[A]: MyList[A] = ???

  }

  val emptyListOfInts = MyList.empty[Int]

  // Variance Problem
  // If cat extends animal does a list of cat extend list of animal?
  //***********************************************

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes - List[Cat] extends List[Animal] = COVARIANCE

  class CovarianceList[+A]
  val animal: Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]
  // can I add any animal to it
  // animalList.add(new Dog) ? HARD QUESTION! --> it becomes a list of Animal!

  // 2. No = Invariance

  class InvariantList[A]
  val invarianceAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell No = Contravariance

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Types
  // If cat extends animal does a list of cat extend list of animal?
  //***********************************************

  // has to be subtypes of Animal inclusive
  class CageSub[A <: Animal](animal: A)
  val cage1 = new CageSub(new Dog)
  val cage2 = new CageSub(new Animal)

  // has to be supertype of Animal inclusive
  class CageSuper[A >: Animal](animal: A)
  val cage3 = new CageSuper(new Animal)

  // compiler error
  //class Car
  //val newCage = new Cage(new Car)





}
