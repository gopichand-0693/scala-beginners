package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steriods

  val random = new Random

  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "somthing else" // _ is called wild card it will match anything
  }

  // 1. Decompose values

  case class Person(name: String, age: Int)
  val bob = Person("bob", 20)

  val greeting = bob match {
    case Person(n, a) if a<21 => s"Hi, my name is $n and I am $a years old."
    case _ => "I don't know who am I."
  }
  println("greeting")

  /*
   1. Cases are matched in order
   2. If no case is matched it will return scala.MatchError so always keep case _
   3. what is type of the pattern match expression ? ans : unified type of all the types in all the case
   4. pattern matching works really well with cae classes
  */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val aninmal: Animal = new Dog("Terra Nova")

  animal match {
    case Dog(someBreed) => println(s"Matched a Dog of the $someBreed breed")

  }

}
