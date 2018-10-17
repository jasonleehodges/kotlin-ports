package io.jasonleehodges.kotlinports


/** An implicit class that allows for using the singleOrNull() method from Kotlin.
  *
  * Usage takes any sequence and converts it to an ImplicitSingleOrNull object. That object
  * has access to the singleOrNull method that will return the lone item from a single item
  * sequence or null if the sequence has more than one item.
  *
  * Example:
  * val singleItemSeq = List(1)
  * val item = singleItemSeq.singleOrNull()
  *
  * The variable item will be assigned the value 1.
  * */
class ImplicitSingleOrNull(seq: Seq[Any]) {
  def singleOrNull(): Any ={
    if(seq.size != 1) return null
    return seq.head
  }
}

object ImplicitSingleOrNull {
  implicit def seqToSingleItemSeq(seq: Seq[Any]) = new ImplicitSingleOrNull(seq)
}
