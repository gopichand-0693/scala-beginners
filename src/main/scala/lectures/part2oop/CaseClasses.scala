package lectures.part2oop

object CaseClasses extends App {

  /*
  *   Quick light weight data structures with little boilerplate
  *   equals, hashcode, toString
  * */

  case class Person( name:String, age:Int)
  // only diff is the key word key
  // but this Key word most powerfull as it does multiple things
  // 1. class params are auto converted to fields
  val jim = Person("Jim", 26)
  println(jim.name)

  // 2. sensible toStirng

  println(jim.toString) //  println(jim) is also converted to jim.toString // Syntactic sugar
  // with out case key word, jim.toString would print some hashcode "lectures.part2oop.CaseClasses$Person@3d8c7aca"

  // 3. equals and hashcode implemented OOTB
  val jim2 = new Person("Jim" , 26)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age=45)

  //5. CCs (case classes ) have companion objects

  val thePerson = Person
  val mary = Person("mary", 34) // no need for the key word new, cos of apply method

  // Serializable , which is gret for distributed systems

  case object abcd {}

}
