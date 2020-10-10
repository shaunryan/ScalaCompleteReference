package lecture.part2.oop // this is not an expression

//import playground.Cinderella
//import playground.{PrinceCharming, Cinderella}
//import playground._
//import playground.{PrinceCharming, Cinderella => Princess}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {


  // package object - universal constants or methods that reside outside of classes - create a package object
  sayHello

    // default imports - automatically imported
      // java.lang - String, Object, Exception
      // scala - Int, Nothing, Function
      // scala.Predef - println, ???
}
