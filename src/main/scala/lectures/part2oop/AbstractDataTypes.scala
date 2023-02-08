package lectures.part2oop

import lectures.part2oop.AbstractDataTypes.Animal

object AbstractDataTypes extends App {
  // abstract

  abstract class Animal {
    val creatureType : String // un Implemented
    def eat:Any               // un implemented
  }
  // abstact classes cannot be instantiated
  // val animal = Animal will give error
  class Dog extends  Animal {

    override val creatureType: String = "K9"
    def eat: Unit = println("Crunch crunch")
  }

  // traits

  trait Carnivore { // utimate abstact type
    def eat(animal: Animal): Unit = {
      println("I am a meat eater")
    }
  }

  // triats vs abstact classes
  // 1- traits do not have constuctor parameters
  // 2- multiple traits may be inherited by the same class
  // 3- traits = behavior, but abstact class  is a type of "thing"


  class  Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    def eat: Unit = println("something")
    override def eat(animal: Animal): Unit = println(s"I am a Croc and I am eating ${animal.creatureType}")
  }

  val dog  = new Dog
  val croc = new Crocodile

  croc.eat(dog)
  croc.eat
}

// Any -> Any ref  -> String , List, Set, -> Scala null -> Scala.nothing
//     -> Scala.AnyVal -> Int, unit, Boolean, Float     -> Scala.nothing
