package lecture.part2.oop

object InheritanceTraits extends App{

  println("*******************************************************")
  println("Basic Inheritance")
  println("*******************************************************")

  class Animal {
    val creatureType = "Wild"
    // public accessible
    def eat = println("nomnomnom")

    // only accessible in this class
    // private def eat = println("nomnomnom")

    // only accessible in this class and the subclass
    protected def protectedEat = println("nomnomnom")
  }

  // subclass of animal, single class inheritance
  class Cat extends Animal {
    def crunch = {
      protectedEat // not accessible outside the subclass
      println("crunch crunch")
    }
  }

  // inherits non private members of the subclass
  val cat = new Cat
  cat.eat

  // protected
  cat.crunch
  // however protectedEat not accessible here
  // cat.protectedEat


  println("*******************************************************")
  println("Constructors")
  println("*******************************************************")

  class Person(name:String, Age:Int){
    // auxiliary
    def this(name:String) = this(name, 0)

  }
  // JVM needs to call constructor from the PARENT CLASS 1ST! -> so must pass arguments for super class
  class Adult1(name:String, age:Int, idCard:String) extends Person(name, age)
  class Adult2(name:String, age:Int, idCard:String) extends Person(name)

  println("*******************************************************")
  println("Overriding")
  println("*******************************************************")

  class Dog1 extends Animal {
    override val creatureType = "Domestic"
    override def eat = println("crunch crunch")
  }

  val dog1 = new Dog1
  dog1.eat
  println(f"dog1.creatureType = ${dog1.creatureType}")

  // override in constructor as a class parameter
  class Dog2(override val creatureType: String) extends Animal {
    override def eat = {
      println("crunch crunch")
      super.eat
    }
  }

  val dog2 = new Dog2("K9")
  dog2.eat
  println(f"dog2.creatureType = ${dog2.creatureType}")

  // equivalent too
  class Dog3(dogType: String) extends Animal {

    override val creatureType = dogType
    override def eat = println("crunch crunch")
  }

  val dog3 = new Dog3("K9")
  dog3.eat
  println(f"dog3.creatureType = ${dog3.creatureType}")

  println("*******************************************************")
  println("Type Substitution (broadly known as POLYMORPHISM")
  println("*******************************************************")

  val unknownAnimal: Animal = new Dog2("K9")
  // this will call the most specialised overridden implementation of eat in this case dog
  unknownAnimal.eat
  // will be crunch crunch
  // will also be nomnomnom because the overidden method calls the super method of eat

}

// **********************************
// Prevent Overriding

// 1. use final on the member
// 2. use final on the class
// 3. seal the class, extend classes in this file but prevent extension in any other file