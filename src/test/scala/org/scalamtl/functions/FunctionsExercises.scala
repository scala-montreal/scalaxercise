package org.scalamtl.functions

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

class FunctionsExercises extends FunSuite {

  test("example of function definition") {
    //The following code defines a function 'reverse' with a single String parameter and returns a String value.
    //Note that the last statement of a block produces the returned value.
    def reverse(string: String): String = {
      string.reverse
    }

    //The 'val' keyword is used to define a value. The value can not be reassigned.
    //The 'var' keyword is used to define variable that can be reassigned, but should be avoided.

    //The function is a first class citizen and can be assigned to a value.
    //It can be passed around like any other objects.
    //Note that the type of the function is (String) => String.
    val reverseFunction: (String) => String = reverse

    val name: String = "scala"

    //Here the function is called
    assert(reverse(name) === "alacs")
    assert(reverseFunction(name) === "alacs")
    assert(reverseFunction.apply(name) === "alacs")
  }

  ignore("high order functions") {
    //High-Order function are functions that takes other functions as parameter or returns a function.
    //The following format function takes two arguments it is of type (String, (String) => String) => String
    //The format function should add '!' before and after the passed string after having applied the preProcessing
    //function.
    def format(string: String, preProcessing: (String) => String): String = {
       ???
    }

    val name = "scala"
    assert(format(name, ???) === "!SCALA!")
  }

  //Scala collections are immutable by default. This means that any operation on a List for example produces
  //another list.
  ignore("reversing a list") {
    val list = List(1, 2, 3)

    val reverseList: List[Int] = ???
    assert(reverseList === List(3, 2, 1))
  }

  //One powerful function is map(). It applies a function to each element of a collection and return a new collection
  //with the modified elements.
  test("list element transformation via map()") {
    val list = List(1, 2, 3)
    val doubledList = List(2, 4, 6)

    //Simple function can be defined inline
    def double(i: Int): Int = i * 2

    //There are many way to pass a function as an argument depending on the function signature.

    //This is the full version with anonymous function
    assert(list.map((i: Int) => double(i)) === doubledList)
    assert(list.map(i => double(i)) === doubledList)

    //The first '_' mean the first argument, the second '_', the second argument...
    assert(list.map(double(_)) === doubledList)
    assert(list.map(double) === doubledList)
    assert(list.map(i => i * 2) === doubledList)
    assert(list.map(_ * 2) === doubledList)
  }

  ignore("using high order list functions") {
    //Imperative style program explain 'how' to perform the computation
    def imperativeStyle(list: List[Int]): List[Int] = {
      //A ListBuffer is a mutable version of List
      val buffer = ListBuffer[Int]()
      for(i <- list) {
        if(i > 0) {
          buffer += 2 * i
        }
      }
      buffer.toList
    }

    val list = List(-1, 2, -3, 4)
    val expectedList = List(4, 8)

    assert(imperativeStyle(list) === expectedList)

    //By chaining and using high order function it is possible to tell 'what' should be done.
    //The 'what' is left to the lower level functions that acts as building blocks.
    def functionalStyle(list: List[Int]): List[Int] = {
      //should be one liner :)
      ???
    }

    assert(functionalStyle(list) === expectedList)

  }

  ignore("create a function that creates a function that multiply by a fixed number") {
    //The return type of 'times' is (Int) => Int, a function that takes an Int and produces an Int.
    //Implement 'times' such that the return function multiply its argument by a fixed number.
    //Note: this is called function currying.
    def times(time: Int): (Int) => Int = {
      ???
    }

    def times2 = times(2)
    assert(times2(2) === 4)
    assert(times(4)(4) === 16)
  }

  ignore("same as above, but with the multiple parameter list syntax") {
    //Scala functions can take more than one parameter list.
    //If called with only one set of parameters, it return a functions that has its first set of parameters fixed and
    //that takes the other sets of parameters.
    def times(time: Int)(arg: Int): Int = {
      time * arg
    }

    def times2: (Int) => Int  = times(2)
    assert(times2(2) === 4)
    assert(times(4)(4) === 16)
  }

}
