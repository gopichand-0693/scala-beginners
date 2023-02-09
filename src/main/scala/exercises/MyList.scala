package exercises

import scala.runtime.Nothing$

abstract class MyList[+A] {

   // val MyListOfCats = MyList[Cats]
   // val MyListOfAnimals   = Mylist[Animals]

  /*
    head  = first elem ent of the list
    tail =  remainder of the list
    methods
    isEmpty = is this List empty
    add(int) => new list with this element added
    toString => String representation of the List
  */

  def head: A
  def tail : MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element:B): MyList[B]

  def printElements: String

  override def toString: String = "["+printElements+"]"

}

object Empty extends MyList[Nothing]{ // objects can extend classes

  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean =  true
  def add[B>:Nothing](element: B): MyList[B] =  new Cons(element, Empty)

  def printElements : String = ""

}

class Cons[+A](h:A, t:MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = if (t.isEmpty) "" + h else  t.printElements +" "+ h
}


object ListTest extends  App {
  // def main(args: Array[String]) = {

  val linklist = new Cons(1,Empty)
  println("Head of this LL is : "+linklist.head)
  println("tail of this LL is : "+linklist.tail)
  val linklist3 = linklist.add(6).add(7).toString
  println("linked list 2 "+linklist3)


 }



