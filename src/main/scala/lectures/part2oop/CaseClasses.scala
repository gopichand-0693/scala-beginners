package lectures.part2oop

object CaseClasses extends App {

  /*
  *   Quick light weight data structures with little boilerplate
  *   equals, hashcode, toString
  * */

  case class Person( name:String, age:Int)
  // only diff is the key word key
  // but this Key word most power full as it does multiple things
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

  /*
  Exercise MyList
  1. create a generic trait called MyPredicate[T] with little method test(T) => Boolean
   it will have a small method to test weather a value of type T passes a condition 
  
  trait MyPredicate[T] {
  def test[T](a : T): Boolean 
  }
  
  every subclass of MyPredicate[T] will have a different implementation of that little method
  
  2. create generic train called MyTransformer[A, B] and small method transform(A) => B
  to convert type A to type B
  every subclass of myTransformer will have different implementation of that method
   
  3. implement following functions on MyList
   - implement function called map() that takes MyTransformer and returns new MyList of diff type
   - map(transformer) => MyList
   - filter(predicate) => MyList
   - flatmap(transformer from A to MyList[B]) => MyList[B]
  
  class EvenPredicate extends MyPredicate[Int]
  class StringToIntTransformer extends MyTransformer[String, Int]
  
  
  if MyPredicate and MyTransformer are defined correctly then the 
  map , filter and flatmap should follow as follow
  
  [1, 2, 3].map(n*2) should give result in (2,4,6)
  [1,2,3,4,].filter(n%2 = true) = [2,4]
  [1,2,3,4].flatmap(n=> [n,n+1]) should result [1,2,2,3,3,4,,4,5]
  
  Hint define Mypredicate[-T] and MyTransformer[-A, B] this is very important
  above hint is a deep rabbit hole and advanced concept just assume as is and use it as is
  
   */

}
