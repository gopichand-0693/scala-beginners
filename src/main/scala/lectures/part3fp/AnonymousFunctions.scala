package lectures.part3fp

object AnonymousFunctions extends App {

  val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x*2
    // still an OO way of defining anonymous function and instantiating it on the spot
  }

  /* In Scala we just do that by deleting all the scrap and just
  * wrting like below code with less boiler plate or   syntactic sugar */

  // Called as Anonymous func call Lambda

  val doubling : ((Int, Int) => Int) = (x, y) => x*2 +y

  //or

  // val doubling = (x :Int, y:Int) => x*2 +y

  println(doubling(2,4))

  // no params

  val jusDoSomething : () => Unit = () => println("In don't have any type of parameter.")

  println(jusDoSomething())
  println(jusDoSomething)
  // while calling Lambdas we must use with paranthesis to execute , u need to be very areful

  // another way of writing lambda
  // Curly braces

  val stringToInt = { (str :String) =>
    str.toInt
  }

  // more sysntactic sugar

  val niceIncrementer: Int => Int = x => x+ 1

  // can be writtenas

  val nicIcrementer: Int => Int = _+1 // euivalent to x=> x+1

  val niceAdded:(Int, Int) => Int = _+_ //equivalent to (a,b) => a+b
}

/*
* */
