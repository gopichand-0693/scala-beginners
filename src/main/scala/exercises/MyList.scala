package exercises

abstract class MyList {

  /*
    head  = first elem ent of the list
    tail =  remainder of the list
    methods
    isEmpty = is this List empty
    add(int) => new list with this element added
    toString => String representation of the List
  */

  def head: Int
  def tail : MyList
  def isEmpty: Boolean
  def add(element:Int): MyList

  def printElements: String

  override def toString: String = "["+printElements+"]"

}

object Empty extends MyList{ // objects can extend classes

  def head: Int =  throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean =  true
  def add(element: Int): MyList =  new Cons(element, Empty)

  def printElements : String = ""

}

class Cons(h:Int, t:MyList) extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)

  def printElements: String = if (t.isEmpty) " " + h else h+" "+t.printElements
}

trait LIST[T] {
  def isEmpty:Boolean
  def head: T
  def tail:List[T]
}
abstract class CONS[T]( head:Int, tail: LIST[T]) extends LIST[T] {
  def isEmpty: Boolean = false
}
class Nil[T] extends LIST[T]{
  def isEmpty: Boolean = true
  def head = throw  new NoSuchElementException()
  def tail = throw  new NoSuchElementException()

}

def nth[T](xs:LIST[T], n:Int): T = {
  if (xs.isEmpty) throw new IndexOutOfBoundsException
  else if (n==0) xs.head
  else nth[T](xs, n-1)
}

println(nth(CONS(1,CONS(2,CONS(3,Nil))),2)
// a list is either
// an empty list Nil() or
// a list cons(x, xs) consisting of a head element x and a tail list xs



object ListTest {
  // def main(args: Array[String]) = {
  def main(args: Array[String]) = {
  }

  val linklist = new Cons(1,Empty)
  println("Head of this LL is : "+linklist.head)
  println("tail of this LL is : "+linklist.tail)
  println(linklist.add(6).head)
  println(linklist.add(7).head)
  println(linklist.printElements)



}




