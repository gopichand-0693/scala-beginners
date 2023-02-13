package lectures.part2oop

// package is a bunch of code definitions grouped under the same name
// for example  package lectures.part2oop is one of the few codes that is not an exception
// package definition says pacakge lectures.part2oop
// this basically says , what ever the definitons that we write in this file wil be part of lectures.part2oop package
// packages mirror the file structure 
// if from the root the package is referred its called FQ fully qualified name

// packagr objects = hold standalone methods/constants
// only one per package
// name aliasong 

import java.util.Date
import java.sql.Date
import java.util

// can be re written with alising as 

import java.{util => ju}
import java.util._
import java.util.{Date => javaDate}
import java.sql.{Date => javaSqldate}

object PackagingAndImports extends  App {

  val writer = new Writer("Daniel","RockTheJVM",2018)

}
