package lectures.part1basics

object ValuesVariablesTypes extends App{

  val x:Int = 42
  println(x)
  // vals are Immutable
  // types of vals are Optional ,
  // compiler can Infer types

  val aString:String = "hello" ; val anotherString = "goodbye" // this semicolon way is discouiraged
  // good way

  val anotherstring : String = "good bye"

  val aBoolean : Boolean = true
  val aChar: Char = 'a'
  val anInt:Int = 45
  val aShort:Short = 543
  val aLong:Long = 14567876543L
  val aFloat:Float = 2.0f
  val aDouble :Double = 3.14
  
  
  // variables
  var aVariable :Int = 4
  
  // variables are mutable
  aVariable =5 // sdie effects
  
  




}
