package exercises

import org.scalatest.FunSuite
import scala.util.{Try, Success, Failure}

class Exercises_E_OptionEitherTry extends FunSuite {

  //Scala provide many constructs to deal with exceptional/error cases without aborting the function call
  //with an Exception that may or may not be handled properly.

  //Experiment with Option, Either, Try
  ignore("safe string to int parsing with Option") {
    def parse(s: String): Option[Int] = {
      ???
    }

    assert(parse("abc") === None)
    assert(parse("123") === Some(123))
  }

  ignore("safe string to int parsing with Either (return either int of error message)") {
    def parse(s: String): Either[String, Int] = {
      ???
    }

    assert(parse("abc") === Left("error"))
    assert(parse("123") === Right(123))
  }

  ignore("safe string to int parsing with Try") {
    def parse(s: String): Try[Int] = {
      ???
    }

    assert(parse("abc").isInstanceOf[Failure[_]])
    assert(parse("123") === Success(123))
  }

}
