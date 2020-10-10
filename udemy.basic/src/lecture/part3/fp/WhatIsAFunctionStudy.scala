package lecture.part3.fp

object WhatIsAFunctionStudy extends App{


//  def add = (x:Int, y:Int) => x + y

//  def add:Function2[Int, Int, Int] = new Function2[Int, Int, Int](2, 2)

//  def add = new Function2[Int, Int, Int] {
//    override def apply(x:Int, y:Int):Int = {
//      x + y
//    }
//  }

//  def add = new ((Int, Int) => Int) {
//    override def apply(x:Int, y:Int) = {
//      x + y
//    }
//  }


//  def add = (x:Int, y:Int) =>  {
//    x + y
//  }

  def add = (x:Int, y:Int) => x + y

  print(add(1, 2))

}

