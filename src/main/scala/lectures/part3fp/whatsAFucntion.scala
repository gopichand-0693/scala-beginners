package lectures.part3fp

object whatsAFucntion extends App {

  /*
  The whole purpose of the fp lectures is
  to use and work with functions as first class elements
  which means we want to work with functions like we work with  plain values
  like pass functions as params and use fucntions as values that's the dream.
  The problem however is we come from OO world where everything is an object
  meaning every thing is an instance of some kind of class
  this is Jvm is originally designed for Java , only the instances of classes and nothing else
  the only way you could simulate FP is to use classes  and instances of those classes
  */


  // Here we have a class and a method say execute  which takes int and string  below

  // we need to instantiate this classs either anonymously or non anonymously
  class Action_1{
    def execute(element:Int) : String = "Hellow world"

  }

  // lets generecise the above class

//  trait Action[A,B]{
//    def execute(element :A) :B = {}
//  }

  // this is what at most an object oriented language would be able to do
  // again this is how jvm is naturally constructed
  // Scala had to resort to some clever tricks to make is look likea truly FP

  trait MyFunction[A,B]{
    def apply(element : A) : B
  }

  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element * 2
  }

  // this is an Instace of this little function like class
  // but the advantage of Scala is as apposed to Java , is we can actually called doubler like
  // doubler(2) like it were a function
  // doubler actually calls the apply method and prints 4 on the console

  println(doubler(2))

  // for now doubler which is an instance of a function like class
  // can be called like a function
  // now the interesting thing is that scala supports these out of the box
  // and the function types Fucntion_X

  // function types = Function[A,B]

  val StringToIntConverter = new Function1[String,Int]{
    override def apply(string: String): Int = string.toInt
  }

  print(StringToIntConverter("20")+4)

  val adder : (Int, Int)=> Int =  new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int = a+b
  }

  println(adder(2,2))

  /*
  val adder : Function2[Int, Int, Int] =  new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int = a+b
  }
  or
  val adder : ((Int, Int) => Int) = new Function2[Int, Int, Int]{}
  // a syntactic sugar for function 2
  *
  * */

  // so we are getting closer to functional programming

  // function types Function2[A, B, R] === (A,B) => R

  // MAJOR TAKE AWAY AND ELEPHANT IN THE ROOM ,
  // ALL SCALA FUNCTIONS ARE OBJECTS OR INSTANCES OF CLASSES DERIVED FROM  Function1, Function2 etc

  // So we are laying the groundwork here for the Scala to act like FP which wa never
  // intended to be a FP language for JVM

  /*
  1.a func which take 2 strings and concatenate them
  2.go to MyList Implementation and transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an Int and returns another func
  -- what the type of this function
  -- how to do it
   */

  def concatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1+" "+v2
  }


  println(concatenator("Hello" , "world"))

  // HOF that return the fucn as return type

  //Fuction1[Int, Function1[Int, Int]]

  val superAdder : Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]]{
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int =
        x+y
    }
  }

  val added = superAdder(30)
  println(added(40))

  // or

  println("or a curried version of added is :") 

  println("Curried version superAdder(30)(40) " + superAdder(30)(40))




}
