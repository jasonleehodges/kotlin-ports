package com.github.jasonleehodges.kotlinports

import org.scalatest.FunSuite
import ImplicitSingleOrNull._
import scala.collection.mutable

class ImplicitSingleOrNullTest extends FunSuite {
  val singleSeq: Seq[String] = List("Jason")
  val multipleIntSeq: Seq[Int] = Array(1,2,4,5)
  val multipleAnySeq: Seq[Any] = mutable.Queue("Jason", "Lee", 2)
  val zeroItemSeq: Seq[Any] = List.empty[Any]

  test("A sequence with only one item should return its item") {
    assert(singleSeq.singleOrNull() == "Jason")
  }

  test("An Array of integers with more than 1 item should return null"){
    assert(multipleIntSeq.singleOrNull() == null)
  }

  test("An Array of Any type with more than 1 item should return null"){
    assert(multipleAnySeq.singleOrNull() == null)
  }

  test("An empty list should return Null"){
    assert(zeroItemSeq.singleOrNull() == null)
  }
}
