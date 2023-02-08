package lectures.part2oop

object Generics extends App {

  class MyList[A]{
    // use the type A inside the class definition
  }
  
  class MyMap[Key, value]
  // also works for the traits 
  
  val listofIntergers = new MyList[Int]
  val listofStrings   = new MyList[String]
  
  // generic methods
  object MyList{
    def empty[A] :MyList[A] = ???
  }
  val emptyListOfIntergers = MyList.empty[Int]
  
  // variance problem
  
  class Animal
  class Cat extends Animal
  class Dog extends  Animal
  
  // Question is if Cat extend Animal does list of cat extend Animal - 
  // there are threee possible ans to this question
  // 1. yes - List[Cat] extends List[Animal] = Covariance
}
