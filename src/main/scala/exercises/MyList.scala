package exercises

abstract class MyList[+A]{

  /*
  *  head =first element of the list
     tail = remainder of the list
     isEmpty = is this list empty
  add(Int) => new list with this element added
  toString => a string representation of the list
   cons
  /    \
 3     cons
      /   \
     4     cons
           /  \
          4    Empty
  */



  def head : A
  def tail : MyList[A]
  def isEmpty : Boolean
  def add[B >: A](element: B) : MyList[B]
  def printElements : String // polymorphic call

  override def toString: String =  "[" + printElements + "]"


  //def map[B](transformer: MyTransformer[A,B]): MyList[B] can be written as
  def map[B](transformer: A=>B): MyList[B]


  // def flatMap[B](transformer: MyTransformer[A,MyList[B]]) : MyList[B] can be written as
  def flatMap[B](transformer: A => MyList[B]) : MyList[B]


  // def filter(predicate: MyPredicate[A]): MyList[A] can be written as
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](myList: MyList[B]): MyList[B]
}
object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element : B): MyList[B] = new Cons(element, Empty )
  def printElements: String = ""

  /*
   these 3 map, flatmap, filter here are especially called higher order function
   as they accept HOF or higher order fuctions , as they recieve func as params or
   return the fucn as return types
  */
  def map[B](transformer: Nothing => B ): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing]= Empty

  def ++[B >: Nothing](list : MyList[B]): MyList[B] = list

}
class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element : B) : MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h else ""+ h+ t.printElements
  }

  def map[B](transformer: A => B): MyList[B] = {
  new Cons(transformer.apply(h), t.map(transformer))
  }

  /* map explanation
  [1, 2,3].map(n*2)
   = new Cons(2, [2,3].map(n*2))
   = new Cons(2, new Cons(4, [3].map(n*2)))
   = new Cons(2, new cons(4, new Cons(6, Empty.map(n*2))))
   = new Cons(2, new Cons(4, new Cons(6, Empty)))
  */
  def filter(predicate: A => Boolean ): MyList[A] = {
    if (predicate.apply(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
    }

  def ++[B >: A](list: MyList[B]) : MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer.apply(h) ++ t.flatMap(transformer)
  }

  /* flatmap explanation
  [1, 2].flatmap(n => [n, n+1])
  = [1,2] ++ [2].flatmap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
   */



  }



//
//trait MyPredicate[-T] {  // T => Boolean
//  def test(element : T): Boolean
//}
//
//trait MyTransformer[-A, B]{ // A => B
//  def transform(elem : A) : B
//}

object ListTest extends App {
  val listOfIntegers : MyList[Int]  = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherlistOfIntegers: MyList[Int] = new Cons(1, new Cons(5, new Cons(5, Empty)))

  val listOfStrings : MyList[String]  = new Cons("Hello", new Cons("Scala", new Cons("world", Empty)))


  println(listOfIntegers.tail)
  println(listOfIntegers.head)
  println(listOfIntegers.isEmpty)
  println(listOfIntegers.toString)
  println((listOfIntegers ++ anotherlistOfIntegers).toString)


//  println(listOfIntegers.map(new MyTransformer[Int, Int] {
//    override def transform(elem: Int) = elem * 2
//  }).toString)

    println(listOfIntegers.map(new Function1[Int, Int] {
      override def apply(elem: Int) = elem * 2
    }).toString)

  println("anonymous way of writing map : " + listOfIntegers.map(_*2).toString)




  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean = {
      elem % 2 == 0
    }
  }).toString)

  println("anonymous way of writing filter : " + listOfIntegers.filter(_%2 ==0 ).toString)
}