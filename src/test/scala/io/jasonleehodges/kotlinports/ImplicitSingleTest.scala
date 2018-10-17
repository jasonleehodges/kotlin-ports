package io.jasonleehodges.kotlinports

import org.scalatest.FunSuite
import ImplicitSingle._
import scala.collection.mutable

class ImplicitSingleTest extends FunSuite {
  val singleSeq: Seq[String] = List("Jason")
  val multipleIntSeq: Seq[Int] = Array(1,2,4,5)
  val multipleAnySeq: Seq[Any] = mutable.Queue("Jason", "Lee", 2)
  val zeroItemSeq: Seq[Any] = List.empty[Any]

  test("A sequence with only one item should return its item") {
    assert(singleSeq.single() == "Jason")
  }

  test("An Array of integers with more than 1 item should produce an IllegalArgumentException"){
    assertThrows[IllegalArgumentException] {
      multipleIntSeq.single()
    }
  }

  test("An Array of Any type with more than 1 item should produce an IllegalArgumentException"){
    assertThrows[IllegalArgumentException] {
      multipleAnySeq.single()
    }
  }

  test("An empty list should produce an IllegalArgumentException"){
    assertThrows[IllegalArgumentException] {
      zeroItemSeq.single()
    }
  }
}
