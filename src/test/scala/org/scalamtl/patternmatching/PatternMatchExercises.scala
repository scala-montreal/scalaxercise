package org.scalamtl.patternmatching

import org.scalatest.FunSuite
import java.util.NoSuchElementException

class PatternMatchExercises extends FunSuite {

  test("case class and pattern matching") {

    //case class define getters, toString and hashcode
    sealed trait Number
    case class Integer(value: Int) extends Number
    case class Real(value: Double) extends Number
    case class Complex(real: Double, imaginary: Double) extends Number

    def format(n: Number): String = {
      n match {
          //type base matching
        case int: Integer => int.value + "i"
          //extraction base matching
        case Real(v) => v + "r"
          //extraction with if clause
        case Complex(r, i) if i == 0 => r + "r"
        case Complex(r, i) => r + "+" + i +"i"
      }
    }

    assert(format(Integer(1)) === "1i")
    assert(format(Real(1.22)) === "1.22r")
    assert(format(Complex(1.22, 0)) === "1.22r")
    assert(format(Complex(1.22, 2)) === "1.22+2.0i")
  }

  ignore("implement Maybe get") {
    assert(Just(3).get === 3)

    intercept[NoSuchElementException] {
      Void.get
    }
  }

  ignore("implement Maybe isDefined") {
    assert(Just(3).isDefined)

    assert(Void.isDefined === false)
  }

  ignore("implement Maybe getOrElse") {
    assert(Just(3).getOrElse(2) === 3)

    val optInt: MaybeInt = Void

    assert(optInt.getOrElse(2) === 2)
  }

  ignore("implement Maybe map") {
    assert(Just(3).map(_ * 2) === Just(6))

    assert(Void.map(_ * 2) === Void)
  }

  ignore("implement Maybe flatMap") {
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

  ignore("addition of two maybe ints") {
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
