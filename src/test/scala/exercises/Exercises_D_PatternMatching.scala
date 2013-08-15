package exercises

import org.scalatest.FunSuite
import java.util.NoSuchElementException

class Exercises_D_PatternMatching extends FunSuite {

  //Pattern matching is one of the very powerful feature in Scala.
  //It allows you to execute a piece of code according to the type of the object, it's structure and
  //even it's field values.
  test("example - case class and pattern matching") {

    //A trait is like an interface but it can also contains implementation of some functions.
    //It is a building block in Scala for 'mixing-in' behavior into a class.
    //The only difference between a trait and an abstract class, is that the trait has no constructor.
    //A sealed trait constrains all the implementation to be in the same source file.
    sealed trait Number

    //Case classes are usually used for data types.
    //Each argument to the case class is a field and Scala generates all the getters, equals and hashcode.
    //Case classes can also be deconstructed to extract their values.
    //Case classes are great for pattern matching.
    case class Integer(value: Int) extends Number
    case class Real(value: Double) extends Number
    case class Complex(real: Double, imaginary: Double) extends Number

    //An example of pattern matching
    def format(n: Number): String = {
      n match {
          //type base matching, if the number is an Integer, then it's value is bound to 'i'
        case i: Integer => i.value + "i"
          //extraction base matching, 'v' is bound to the value of the value field of the Real class
        case Real(v) => v + "r"
          //extraction with if clause, the if clause can access extracted variables
        case Complex(r, i) if i == 0 => r + "r"
        case Complex(r, i) => r + "+" + i +"i"
      }
    }

    assert(format(Integer(1)) === "1i")
    assert(format(Real(1.22)) === "1.22r")
    assert(format(Complex(1.22, 0)) === "1.22r")
    assert(format(Complex(1.22, 2)) === "1.22+2.0i")
  }

  //The Option type is very useful in Scala. It represents either a value (Some) or the absence of a value (None).
  //It helps avoiding NullPointerExceptions because the type itself enforce the fact that the value can exists or not.

  //Below, there is a simplified Option type called MaybeInt that is partially implemented.
  //The tests will guide you for the implementation.
  ignore("implement MaybeInt get") {
    assert(Just(3).get === 3)

    intercept[NoSuchElementException] {
      Void.get
    }
  }

  ignore("implement MaybeInt isDefined") {
    assert(Just(3).isDefined)

    assert(Void.isDefined === false)
  }

  ignore("implement MaybeInt getOrElse") {
    assert(Just(3).getOrElse(2) === 3)

    val optInt: MaybeInt = Void

    assert(optInt.getOrElse(2) === 2)
  }

  ignore("implement MaybeInt map") {
    assert(Just(3).map(_ * 2) === Just(6))

    assert(Void.map(_ * 2) === Void)
  }

  ignore("implement MaybeInt flatMap") {
    assert(Just(3).flatMap(i => Just(i * 2)) === Just(6))

    val optInt: MaybeInt = Void

    assert(optInt.flatMap(i => Just(i * 2)) === Void)
  }

  ignore("safe int parsing with MaybeInt") {
    def safeIntParsing(string: String): MaybeInt = {
      try {
        ???
      } catch {
        case e: Exception => ???
      }
    }

    assert(safeIntParsing("1") === Just(1))
    assert(safeIntParsing("1s") === Void)
  }

  ignore("using MaybeInt") {
    def toString(v1: MaybeInt): String = {
      ???
    }

    assert(toString(Just(3)) === "3")
    assert(toString(Void) === "-")
  }

  ignore("addition of two MaybeInts") {
    def add(v1: MaybeInt, v2: MaybeInt): MaybeInt = {
      ???
    }

    assert(add(Just(2), Just(3)) === Just(5))
    assert(add(Just(3), Void) === Void)
    assert(add(Void, Void) === Void)
  }

}

sealed trait MaybeInt {
  def isDefined: Boolean

  def get: Int

  def getOrElse(default: Int): Int = ???

  def map(f: Int => Int): MaybeInt = ???

  def flatMap(f: Int => MaybeInt): MaybeInt = ???
}

case class Just(value: Int) extends MaybeInt {
  def isDefined: Boolean = ???

  def get: Int = ???
}

case object Void extends MaybeInt {
  def isDefined: Boolean = ???

  def get: Nothing = ???
}
