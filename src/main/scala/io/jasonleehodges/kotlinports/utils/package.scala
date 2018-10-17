package io.jasonleehodges.kotlinports

package object utils {

  /** A method that repeats a given function n number of times.
    *
    * Example: repeat(5){ println("example") }
    *
    * This will print the string example 5 times.
    * */
  def repeat(times: Int, iter: Int=0)(fun: => Unit) {
    if(iter < times) {
      fun
      repeat(times, iter + 1)(fun)
    }
  }
}
