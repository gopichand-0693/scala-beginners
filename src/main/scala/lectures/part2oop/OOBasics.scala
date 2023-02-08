package lectures.part2oop

object OOBasics extends  App {
val person = new Person("John", 26)
println(person)  // person.age gives error coz class params arenot class fields
// in order to refer the name and age add val or var

person.greet("Daniel")

  val author = new Writer("charles", "Dickens", 1812)
  val imposter = new Writer("charles", "Dickens", 1812)
  val novel = new Novel("Great expectations", 1861, author)

println(novel.authorAge)
}

class Person(name:String, age:Int){ // () is called constructor

  // {} this is called body
// classes arr blueprint of hoe a data looks like and add functionality
val x: Int = 2
println((1+3)) // for every new object instantiation this whole code block is evaluated

// method
  def greet(name: String):Unit = {

    println("this.name is "+this.name)
    println(s"${this.name} says : Hi $name ")

  def greet():Unit = {
    println("this is overlaoded function") // means methods with same name but diff no of params or diff return type or diff types of params
  }
  // multiple contructors
  // def  this(name: String) = this(name, 0) /// didn't understood

  /*
  *  Novel and writer class
  writer : firstname , surname, year of birth

  method : fullname (concat of fname nad sname)

  Novel : name , year of release , author

  mothod: authorAge at year of release
  isWrittenBy
  Copy (new year of release) = new instace of novel


  * */

  /*
  * counter class

  -- recives an int value
  -- method current count
  - method to increment / decrement => new counter
  - overload inc/dec to recieve an amount

  * */



}

}

class Writer(firstname: String, surname: String, val year: Int) {
  def fullName: String = firstname + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year

  def isWrittenBy(author:Writer) = author == this.author

  def copy(newYear:Int) : Novel = new Novel(name , newYear, author)
}

class Counter(val count:Int =0 ){  // default value 0
  // def count = n // getter method  equivalent Counter(val n:Int)
  
  def inc = new Counter(count +1)
  def dec = new Counter(count -1) // immutability
  
  // overloading 
  
  def inc(n:Int) = {
    new Counter(count+1)
  }
  def dec(n:Int) = {
    new Counter(count-1)
  } 
  
  
  
}


