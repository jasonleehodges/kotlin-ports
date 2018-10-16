package com.github.jasonleehodges.kotlinports

import org.scalatest.FunSuite
import utils.repeat
import scala.collection.mutable.Queue

class utilsTest extends FunSuite {

  test("A repeat five times should add up to 5"){
    var value = 0
    repeat(5) {
      value += 1
    }
    assert(value == 5)
  }

  test("A repeat that concatenates words should yield a full sentence."){
    var sentence = ""
    val wordArray = Queue("Jason ", "Lee ", "Hodges")
    repeat(3){
      sentence += wordArray.dequeue()
    }
    assert(sentence == "Jason Lee Hodges")
  }
}
