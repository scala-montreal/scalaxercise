package org.scalamtl.functions

import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer

class FunctionsExercises extends FunSuite {

  test("example of function definition") {
    //Defines a function reverse with a single String parameter and return a String value.
    //The last statement produces the returned value.
    def reverse(string: String): String = {
      string.reverse
    }

    //the function can be assigned
    val reverseFunction: (String) => String = reverse

    val name: String = "scala"

    //calling the function
    assert(reverse(name) === "alacs")
    assert(reverseFunction(name) === "alacs")
    assert(reverseFunction.apply(name) === "alacs")
  }

  ignore("simple higher order function") {
    def format(string: String, preProcessing: (String) => String): String = {
       ???
    }

    val name = "scala"
    assert(format(name, ???) === "!SCALA!")
  }

  ignore("simple list functions") {
    val list = List(1, 2, 3)

    val reverseList: List[Int] = ???
    assert(reverseList === List(3, 2, 1))
  }

  test("list transformation via map()") {
    val list = List(1, 2, 3)
    val doubledList = List(2, 4, 6)

    def double(i: Int): Int = i * 2

    assert(list.map((i: Int) => double(i)) === doubledList)
    assert(list.map(i => double(i)) === doubledList)
    assert(list.map(double(_)) === doubledList)
    assert(list.map(double) === doubledList)
    assert(list.map(i => i * 2) === doubledList)
    assert(list.map(_ * 2) === doubledList)
  }

  ignore("list operations") {

    def imperativeStyle(list: List[Int]): List[Int] = {
      //buffer is a mutable version of List
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

    def functionalStyle(list: List[Int]): List[Int] = {
      //should be one liner :)
      ???
    }

    assert(functionalStyle(list) === expectedList)

  }

  ignore("create a function that creates a function that multiply by a fixed number") {
    def times(time: Int): (Int) => Int = {
      ???
    }

    def times2 = times(2)
    assert(times2(2) === 4)
    assert(times(4)(4) === 16)
  }

}
