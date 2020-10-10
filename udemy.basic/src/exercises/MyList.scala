package exercises

abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // This is a polymorphic call and will call printElements of the of the specific type
  override def toString: String = s"[${printElements}]"

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

//  OOP WAY
//  def map[B](transformer: MyTransformer[A,B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]

  //  FP WAY - These are called HIGHER ORDER FUNCTIONS
  // Receive functions as parameters or return function
  // Function3 types
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  // Function2 type
  def filter(predicate: A => Boolean): MyList[A]

}

object Empty extends MyList[Nothing] {

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""


  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
//  OOP WAY
//  def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
//  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

//  FP WAY
    def map[B](transformer: Nothing => B): MyList[B] = Empty
    def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
    def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
}

class Cons[+A](h:A, t:MyList[A]) extends MyList[A] {

  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) s"$h"
    else s"$h ${t.printElements}"

  /*
    [1.2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /*
    [1,2].flatMap(n => [n, n+1])
    = [1,2] ++ [2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */

//  OOP WAY
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
//    transformer.transform(h) ++ t.flatMap(transformer)
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  /*
    [1, 2, 3].map(n * 2)
      = new Cons(2, [2, 3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))


   */

//  OOP WAY
//  def map[B](transformer: MyTransformer[A,B]): MyList[B] =
//    new Cons(transformer.transform(h), t.map(transformer))
def map[B](transformer: A => B): MyList[B] =
  new Cons(transformer(h), t.map(transformer))

  /*
    [1,2,3].filter(n % 2 == 0) =
      [2,3].filter(n % 2 == 0) =
      = new Cons(2, [3].filter(n % 2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
   */
//  OOP WAY
//  def filter(predicate: MyPredicate[A]): MyList[A] =
//    if (predicate.test(h)) new Cons(h, t.filter(predicate))
//    else t.filter(predicate)
def filter(predicate: A => Boolean): MyList[A] =
  if (predicate(h)) new Cons(h, t.filter(predicate))
  else t.filter(predicate)
}



//trait MyPredicate[-T] {
//  def test(elem: T): Boolean
//}
//
//trait MyTransformer[-A, B] {
//  def transform(elem: A): B
//}

object ListTest extends App {

  // Exercise 1 - oo
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(4).head)
//  println(list.isEmpty)
//  // call toString in MyList
//  println(list.toString)

  // Exercise 2 - generics
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

//  OOP WAY
//  println(listOfIntegers.map(new MyTransformer[Int, Int] {
//    override def transform(elem: Int): Int = elem * 2
//  }).toString)
//
//  println(listOfIntegers.filter(new MyPredicate[Int] {
//    override def test(elem: Int): Boolean = elem % 2 == 0
//  }).toString)
//
//  println((listOfIntegers ++ anotherListOfIntegers).toString)
//  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
//    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
//  }).toString)

//  FP WAY
    println(listOfIntegers.map(new Function1[Int, Int] {
      override def apply(elem: Int): Int = elem * 2
    }).toString)

    println(listOfIntegers.filter(new Function1[Int, Boolean] {
      override def apply(elem: Int): Boolean = elem % 2 == 0
    }).toString)

    println((listOfIntegers ++ anotherListOfIntegers).toString)
    println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
      override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
    }).toString)

}
