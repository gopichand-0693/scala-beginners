package lectures.part1basics

object Functions extends App {

  def aFunction(a:String, b:String):String = {
    a + "-"+ b
  }
    println(aFunction("Hi","Hello"))

    // when u need loops, use recursion

  def aRepeatedFucntion(aString :String, n:Int):String = {
    if (n==1) aString
    else aString + aRepeatedFucntion(aString, n-1)
  }

  // return type of recursive functions is a must , as a best practice always mention return type 

  println(aRepeatedFucntion("hello", 3))

  def aFucntionWithSideEffects(aString: String): Unit = println(aString)

  println(aFucntionWithSideEffects("hell0"))




  /*

   */
}





