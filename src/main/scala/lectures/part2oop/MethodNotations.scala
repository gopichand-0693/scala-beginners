package lectures.part2oop

object MethodNotations extends  App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie:String):Boolean = movie == favouriteMovie

    def hangOutWith(person: Person):String = s"${this.name} is hanging  out with ${person.name}"
  }

  val mary = new Person("mary", "Inception")

  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix notation, works only with single method

  // above infix notation is an example of syntactic sugar

  // "operators" in scala

  val  tom = new Person("Tom", "Fight club")

  println(mary hangOutWith( tom))

  println(1 + 2) // equivalent of println(1.+2)

  // prefix notation

  val x = -2
}
