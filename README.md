# kotlin-ports
A port of useful Kotlin functionality to Scala using implicits.


### SBT use

```
libraryDependencies += "io.jasonleehodges" % "kotlin-ports_2.12" % "0.1.2"
```

This package is meant to port useful functionality that I've found in Kotlin over to Scala. 
The four current pieces include:

* `.single()` - this method can be chained at the end of any sequence to pull out the lone item from a single item sequence. If there 
is not only a single item the method will throw an exception.

* `.singleOrNull()` - this method works the same as `single()` except it returns null in the even that there is not exactly one item in the sequence.

* `repeat` - this function is used to repeat a given function `n` number of times (however many times you pass in as an argument). 
Example: `repeat(5){ println("test") }` - this will print test 5 times. This is really useful during unit tests if you need to automate the creation of random
objects are api calls or something multiple times.

* Implicit ternary operator - this is more of a port from Java and it's not exact but it's a nice to have. Example `val x = (true) ?? 1 :: 2` will set the variable
x to 1 because the boolean value that it implicitly modifies evaluates to true.

Full example:

```
import io.jasonleehodges.kotlinports.ImplicitSingle._
import io.jasonleehodges.kotlinports.ImplicitTernary._
import io.jasonleehodges.kotlinports.utils._

object main extends App {
  val mylist = List("Single Item")
  (1 + 1 == 2) ?? repeat(5) { println(mylist.single()) } :: println("Too Many Items")
}
```
