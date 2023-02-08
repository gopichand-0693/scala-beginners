package lectures.part1basics

object Recursion extends App {
    def factorial(n: Int): Int = {
      if (n <= 1) 1 else n * factorial(n - 1)
    }
    println(factorial(500000))

    // each call of the recursive function is stored in a stack
  }



