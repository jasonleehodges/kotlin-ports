package com.github.jasonleehodges.kotlinports

class ImplicitSingle(seq: Seq[Any]) {
    def single(): Any ={
      if(seq.size != 1) throw new IllegalArgumentException("Sequence does not contain only a single item.")
      return seq.head
    }
}

object ImplicitSingle {
  implicit def seqToSingleItemSeq(seq: Seq[Any]) = new ImplicitSingle(seq)
}
