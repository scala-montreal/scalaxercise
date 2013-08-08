package org.scalamtl.recursive

import org.scalatest.FunSuite
import scala.annotation.tailrec
import scala.util.control.Breaks._

class Recursive extends FunSuite {

  test("introduction") {
    //Recursive functions are functions that calls themselves. The main problem with recursive functions is that
    //they can lead to StackOverflow. Scala compiler can optimize some recursive functions (those which last statement
    //is the recursive call) to loop using tail-recursion.

    //The tailrec annotation tells the compiler to check that the recursive function can in fact be optimized or else
    //fail the compilation.
    @tailrec
    def find(n: Int, list: List[Int]): Boolean = {
      if (list.size > 0) {
        if (list.head == n) {
          true
        } else {
          find(n, list.tail)
        }
      } else {
        false
      }
    }

    assert(find(2, List(1, 1, 1, 1, 1, 1, 1, 1, 1, 2)))
    assert(!find(2, Nil))
    assert(!find(2, List(1, 1, 1, 1, 1, 1, 1, 1)))
  }

  ignore("compute factorial n") {
    ???
  }

  test("refactor me to tail recursive function") {
    //Scala break statement should be avoided, in fact the language provide 'break' as a library.
    //Often, this indicate the need for a recursive function...
    //Try refactoring this method to use tailrec function internally.
    def countOneBeforeFive(list: List[Int]): Int = {
      var count = 0
      breakable {
        for (i <- list) {
          if (i == 5) {
            break
          } else if (i == 1) {
            count = count + 1
          }
        }
      }
      count
    }

    assert(countOneBeforeFive(List(1, 2, 1, 2, 1, 5, 1)) === 3)
    assert(countOneBeforeFive(List(2, 2, 2, 5, 1)) === 0)
    assert(countOneBeforeFive(Nil) === 0)
  }

}
