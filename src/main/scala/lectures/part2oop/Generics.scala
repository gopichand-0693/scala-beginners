package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element:B):MyList[B] = ???
  }

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]
  class MyMap[Key, Value]

  trait Mylist[A]

  // triat can also be type parameterised

//  object MyList{ // Companion object as object and class have the same name
//    //def empty[A]:MyList[A] = ???
//  }  // object cannot be type parameterised

  //val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal

  class Dog extends Animal
  class Cat extends Animal

  // if Cat extends animal , does a list of cats extend list of animal
  // there are 3 possible ans to this question
  // 1. yes - called covariance

  // case 1
  // yes list[Cat] extends List[Animal] = COVARIANCE
  class CovarianceList[+A]

  val animal:Animal = new Cat
  val animalList:CovarianceList[Animal] = new CovarianceList[Cat] // of course cat is an animal

  // now animalList.add(new Dog) // HARD question as ideally
  // list of animal (animalList val) should contain Dog as Dog is animal Too
  // but doing so would pollute the list of cats already pre assigned
  // so It depends on case


  // Case 2
  // 2. NO - Called invarinace
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // case 3
  // 3. Hell No- ContraVariance

  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // obvious question is how can you replace a list of cats with List of Animals
  // It's not intuitive , its counter intuitive

  // let's take example
  // Instead of CovariantList let's do with the class

  // Case 3, Hell No, Contravariance
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]
  // now here semantics change , I want a trainer of Cat buit I got trainer of Animal ,
  // which is even better

  // bounded types

  class Cage[A <: Animal](animal: A)// class cage only accepts type parameter subtype of A
  // that is how you read and understand it
  val cage = new Cage(new Cat)  // Cat and Dog extends animal new Trainer is not accepted

  // <: subtype ,  >: supertype

}
