package exercises

import org.scalatest.FunSuite

class Exercises_B_Collections extends FunSuite {

  test("example - create some collections") {
    //Scala provides many collections implementations.
    //By default, the collections are immutable. If you want mutable collections,
    //you will have to import them.
    val emptyList = Nil
    val list = List(1, 2, 3, 4)
    val set = Set(1, 2, 2)

    //Some collections functions
    assert(emptyList.length === 0)
    assert(list.head === 1)
    assert(list.tail === List(2, 3, 4))
    assert(set.size === 2)
    assert(set.toList.contains(1))

    //A Map is a list of Tuples. Tuples can be created in two ways.
    // ("a", 2) is the same Tuple as "a" -> 2
    //Usually, the arrow syntax is used for maps.
    val map = Map("k" -> 1, ("kk", 4))

    //The apply operation (using the () directly on the map) returns a value or throws a NoSuchElementException
    assert(map("k") === 1)
    //The get function returns an object of type Option
    assert(map.get("kk").isDefined)

    //Many types support conversion to common collections such as List, Set, etc...
    val string = "abc"
    assert(string.toList === List('a', 'b', 'c'))
  }

  ignore("check palindrome") {
    //This function returns true is the string is the same by reading forward or backward, false otherwise.
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
