package lectures.part2oop

object MethodNotations extends  App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie:String):Boolean = movie == favouriteMovie
    def +(person: Person) = s"this.name is hanging out with ${person.name}"
    def hangOutWith(person: Person):String = s"${this.name} is hanging  out with ${person.name}"
    def isAlive:Boolean = true
    def apply():String = s"Hi, my name is $name and I like $favouriteMovie"

    def apply(n:Int):String = s"Hi my name is mary wath my fav movie $favouriteMovie $n times."
  }

  val mary = new Person("mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation, works only with single method

  // above infix notation is an example of syntactic sugar
  // purpose of  syntactic sugar is to make Scala more natural language look alike

  // "operators" in scala

  val  tom = new Person("Tom", "Fight club")

  println(mary hangOutWith( tom))

  println(1 + 2) // equivalent of println(1.+2)

  // prefix notation

  val x = -3

  println(mary.apply())
  // or
  println(mary()) // both are same  or equivalent becasue it breaks barrier between FP and OOP
  // i.e objects can be used to call as functions with apply method

  /*
  *  1. overload the +operator
  *

  *
  * */

}
