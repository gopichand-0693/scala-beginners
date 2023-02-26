package lectures.part2oop
import playground.{Cinderella, PrinceCharming} // import playground._

/*
package is a bunch of code definitions grouped under the same name
 // for example  package lectures.part2oop is one of the few codes that is not an exception
 package definition says package lectures.part2oop
 this basically says , what ever the definitions that we write in this file wil be part of lectures.part2oop package
 // packages mirror the file structure
 if from the root the package is referred its called FQ - fully qualified name

below is something Scala specific code organising structure  called package object
// package object ?

this package object originated from the problem that sometimes we may want to write methods
ro constants outside of everything else

we can now only write  classes, traits and objects , we can only access values, methods or constants
from them

bu we might need to have some kind of universal constants or universal methods
that reside outside classes that purpiseis full filled by package object


 package objects = hold standalone methods/constants
 only one per package wit name package.scala in whole package
 name aliasing
 */


object PackagingAndImports extends  App {

  val writer = new Writer("Daniel","RockTheJVM",2018)

  val cinderella = new playground.Cinderella // fully qualified name using playgorund .

  /*
  A package is basically a bunch of code or definitions grouped under the same name

  */
  sayHello
  println(speedOfLight)

  val prince = new PrinceCharming

}


// important java packages
import java.util.Date
import java.sql.Date
import java.util

// can be re written with aliasing as
// alternately once can use fully qualified name sto call them or use u can use aliasing

import java.{util => ju}
import java.util._
import java.util.{Date => javaDate}
import java.sql.{Date => javaSqldate}
