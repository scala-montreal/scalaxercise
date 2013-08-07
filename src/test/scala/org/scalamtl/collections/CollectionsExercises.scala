package org.scalamtl.collections

import org.scalatest.FunSuite

class CollectionsExercises extends FunSuite {

  test("create some collections") {
    val emptyList = Nil
    val list = List(1, 2, 3, 4)
    val set = Set(1, 2, 2)

    assert(emptyList.length === 0)
    assert(list.head === 1)
    assert(list.tail === List(2, 3, 4))
    assert(set.size === 2)

    assert(set.toList.contains(1))

    val map = Map("k" -> 1, ("kk", 4))
    assert(map("k") === 1)
    assert(map.get("kk").isDefined)

    val string = "abc"
    assert(string.toList === List('a', 'b', 'c'))
  }

  ignore("check palindrome") {
    def isPalindrome(string: String): Boolean = {
      ???
    }

    assert(isPalindrome("hahah"))
    assert(!isPalindrome("haha"))
  }

  ignore("remove duplicate elements in a list") {
    def removeDuplicate(list: List[Int]): List[Int] = {
      ???
    }

    val initialList = List(1, 2, 2, 3, 3)
    assert(removeDuplicate(initialList) === List(1, 2, 3))
  }

  ignore("collect words with more than 3 letters") {
    def collectLongWords(list: List[String]): List[String] = {
       ???
    }

    assert(collectLongWords(List("mama", "apple", "to", "two")) === List("mama", "apple"))
  }

  ignore("translate numbers to english") {
    def toEnglish(number: Int): String = {
      ???
    }

    assert(toEnglish(42) === "four-two")
    assert(toEnglish(11) === "one-one")
  }
}
