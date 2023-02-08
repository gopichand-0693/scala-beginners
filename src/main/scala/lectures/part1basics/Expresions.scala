package lectures.part1basics

object Expresions extends App{

  val x = 1+2 // this right hand side is called expression
  println(x)
  println(2+3*4) // math operators + - * | % & / ^ == << >> >>> (tight shift with zero extension)

  // == test for the eqality , != negate the equality , >= <= > <

  // negate !, logical orperators and && or ||

  var aVariable = 2

  aVariable +=3  // changing the variable is called sideeffects

  // Instructions vs expressions

  // an Instruction is some thing u would tell the computer top tell something

  // if exp

  val aConditins : Boolean = true

  val aConditinoValue = if (aConditins) 42 else 45

  println("a condition value is : "+aConditinoValue)
  
  var i =0
  
  while (i<10){
    println(i)
    i+=1
  } // NERVER WRITE WHILE OR FOPR LOOPS IN SCALA AGAIN
  
  // Everything i Scala is an Expression
  
  // side effects : println(), whiles , reassigning
  // side effects are reminiscent of imperative programming like Java python etc not the Scala
  
  // code blocks
  
  val aCodeBlock = {
    val y = 2 
    val z = 5+1
    
    if (z> 2) "hello" else "good bye"
  }
  // value of code block is the last value in the block
}

// Expressions vs instructions
// Instructions are executed (think Java), expressions are evaluated (Scala)
// In Scala we'll think in terms of the expressions