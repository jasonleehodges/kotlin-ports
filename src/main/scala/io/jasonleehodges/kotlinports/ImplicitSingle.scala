package io.jasonleehodges.kotlinports

/** An implicit class that allows for using the single() method from Kotlin.
  *
  * Usage takes any sequence and converts it to an ImplicitSingle object. That object
  * has access to the single method that will return the lone item from a single item
  * sequence or throw an exception if the sequence has more than one item.
  *
  * Example:
  * val singleItemSeq = List(1)
  * val item = singleItemSeq.single()
  *
  * The variable item will be assigned the value 1.
  * */
class ImplicitSingle(seq: Seq[Any]) {
    def single(): Any ={
      if(seq.size != 1) throw new IllegalArgumentException("Sequence does not contain only a single item.")
      return seq.head
    }
}

object ImplicitSingle {
  implicit def seqToSingleItemSeq(seq: Seq[Any]) = new ImplicitSingle(seq)
}
