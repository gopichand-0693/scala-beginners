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

}
object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element : B): MyList[B] = new Cons(element, Empty )
  def printElements: String = ""


}
class Cons[+A](h : A, t : MyList[A]) extends MyList[A] {

  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element : B) : MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (tail.isEmpty) " " +h else  " " + h + tail.printElements
  }

}

object ListTest extends App {
  val list  = new Cons(1, new Cons(2, new Cons(3, Empty)))

  println(list.tail)
  println(list.head)
  println(list.isEmpty)
  println(list.toString)
}