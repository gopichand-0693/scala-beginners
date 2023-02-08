package lectures.part2oop

object InheritanceAndTraits extends App{

  class Animal {
    // small little method called eat

    val creature  = "wild"
    def eat = println("nomnom")

    /* final def eat = println("nomnom") // prevent overriding */
    private def eating = println("this is private")
    protected def eater = println("nomnom")

    // access modifiers are by default public (no speciall key word req) ,  private and protected
    // protected method can only be scoped in the child class
  }

  class Cat extends  Animal{
    def cruch = {
      eater
      println("cruch crunch")
    }
  } // Inheritance means extending all the non private fields and methods

  // cat is called dub class and Animal super class
  // Scala offers single class

  val cat = new Cat

  cat.cruch

  // Constuctors

  class Person(name : String, age:Int)
  class Adult(name:String, age: Int, idcard : String) extends Person(name, age)


  //overriding
  class Dog extends Animal{
    override def eat = {
      super.eat // refers to the method int the parent class    // Super - it is used to when u want to refer a method or field from parent class
      println("Bow Bow") }// overriding works ofr methods vals vars
    override val creature = "Domestic"
  }


  // type substitution

  val unKnownAnimal : Animal = new Dog()

  // overriding and overloading
  // Overriding meaning different implementation in derived classes
  // Overloading meaning supplying multiple methods with different signatures with the same name in the same class


  // Preventing Overrides
  // One way          1. to add final keyword before methods
  // second method    2. to make the entire class final
  // sealed           3. extension in the current file is okay but canot be extended in another file


}
