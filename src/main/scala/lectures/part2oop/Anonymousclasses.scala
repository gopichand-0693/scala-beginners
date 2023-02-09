package lectures.part2oop

object Anonymousclasses extends App {

  trait Animal {
    def eat: Unit
  }

  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }

  // when we write new Animal with a on the spot implementation , the compiler creates aonymous classes

  // it creates as

  /*
  class Anonymousclasses$$anon$1 extends Animal {
  override def eat: Unit = println("ahahahahhaah")
  }
   */

  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi , my name is ${this.name}, how can I help")
  }

  val sim  = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi my name is Jim, how may I help you.")
  }

  /*
  1. Generic trait Mypredicate[T]
  2. Generic triat Mytransformer[A, B] => type A into type B
  3. MyList:
  *       -map(transformer)  => MyList
  *       -filter(predicate) => MyList
  *       -faltMap(transformer from A to MyList[B]) => MyList[B]
  */

  
}
