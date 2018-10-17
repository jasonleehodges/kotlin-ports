package io.jasonleehodges.kotlinports

import org.scalatest.FunSuite
import ImplicitTernary._

class ImplicitTernaryTest extends FunSuite {

  test("Ternary operator should eveluate to true and return 19"){
    val testVal = (true) ?? (18+1) :: 2+3
    assert(testVal == 19)
  }

  test("Nested ternary operators should also work."){
    val testVal = (false) ?? 1 :: (true) ?? 2 :: 3
    assert(testVal == 2)
  }

}
