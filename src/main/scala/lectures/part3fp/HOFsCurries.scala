package lectures.part3fp

object HOFsCurries extends App {

  val superFunction : (Int, (String, (Int => Boolean)) => Int ) => (Int => Int) = ???

  // such functions which take functions ans params and return the func as result are HOF

  // create a function that applies a function n times over a value x
  // ntimes(f, n, x) for example ntimes(f, 3, x)
  // the above result is f(f(f(x)))

  // def ntimes[A, B](f : A => B, n: Int, x : Int ) : Any = ???

  def ntimes(f : Int => Int, n: Int, x : Int ) : Int = {
    if (n<= 0) x
    else  ntimes(f, n-1, f(x))
  }

  val plusOne = (x:Int) => x+1
  println(ntimes(plusOne, 10, 1))
  def ntimesBetter(f: Int => Int, n: Int):(Int => Int) =
    if (n<= 0) (x:Int) => x
    else (x:Int) => ntimesBetter(f, n-1)(f(x))

    println(ntimesBetter(plusOne, 10))



}
