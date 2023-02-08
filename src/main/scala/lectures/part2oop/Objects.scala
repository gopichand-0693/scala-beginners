package lectures.part2oop

object Objects extends App {

  /*  Scala does not have class level fucntionality ("static equivalent in java") it have somethis even better
      objects can contain variables vals and vars , methods,  fucntionalities etc
      objects can be defined the same way classes can be , with the exception that objects donot recieve the params

      for example Scala objects are their own class ,  their only instace, single ton patter in one line */


  // Scala Companions
  // They can access each other's private members
  // Scala is more OO than Java
  object Person{ // its a type and its th e only instance ie, Person cannot be instantiated just like class

    // static or class level fucntionality
    val N_EYES = 2
    def canFly:Boolean = false
  }

  class Person{
    // instance level functionality
  }

  // above 2 things is a pattern if writing the Objects and Classes with the same name is called "COMPANIONS"
  // they reside in the same scope and with the same  name
  // the whole code e ever write will either reside in the class or the singleton object which makes it truly OOP
  // a regular instance or singleton instance more OO than any OO language

  println(Person.N_EYES)
  println(Person.canFly)

  /* Scala object = singleton instance which means when object Person is defined that Person is itself only an istance and no further
  Instantiation is possible */

  val mary = new Person
  val john = new Person

  println("mary is equal to john or not : "+{mary == john})

  val mary_ =  Person
  val john_ =  Person

  println("mary is equal to john or not : " + {
    mary_ == john_
  })

  /*Scala Applications =  Scala object with def main()
   def main(args:Array[String]): Unit = { }  this method nees to have this exact java public static void main
*/
}
