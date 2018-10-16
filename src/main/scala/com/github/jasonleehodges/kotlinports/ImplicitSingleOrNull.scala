package com.github.jasonleehodges.kotlinports

class ImplicitSingleOrNull(seq: Seq[Any]) {
  def singleOrNull(): Any ={
    if(seq.size != 1) return null
    return seq.head
  }
}

object ImplicitSingleOrNull {
  implicit def seqToSingleItemSeq(seq: Seq[Any]) = new ImplicitSingleOrNull(seq)
}
