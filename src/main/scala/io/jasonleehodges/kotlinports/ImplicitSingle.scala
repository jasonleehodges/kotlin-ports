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
class ImplicitSingle[A >: Null](seq: Seq[A]) {
    def singleOption(seq: Seq[A]) = {
      seq match {
        case Seq(single) => Some(single)
        case _ => None
      }
    }

  def single[A >: Null]() = {
    singleOption(seq).getOrElse(throw new IllegalArgumentException("Sequence does not contain exactly one item."))
  }

  def singleOrNull[A >: Null]() = {
    singleOption(seq).orNull
  }
}

object ImplicitSingle {
  implicit def seqToSingleItemSeq[A >: Null](seq: Seq[A]) = new ImplicitSingle(seq)
}
