package com.github.jasonleehodges.kotlinports

package object utils {
  def repeat(times: Int, iter: Int=0)(fun: => Unit) {
    if(iter < times) {
      fun
      repeat(times, iter + 1)(fun)
    }
  }
}
