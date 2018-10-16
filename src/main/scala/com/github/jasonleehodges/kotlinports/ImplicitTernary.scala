package com.github.jasonleehodges.kotlinports

class ImplicitTernary (c: => Boolean, tc: => Any){
  lazy val cond = c
  lazy val thenClause = tc
}

object ImplicitTernary {

  implicit class TernaryConverter(cond: => Boolean) {
    def ??(thenClause: => Any) = new ImplicitTernary(cond, thenClause)
  }

  implicit class TernaryElseClause(elseClause: => Any) {
    def ::(ifThenClause: ImplicitTernary): Any =
      if (ifThenClause.cond) return ifThenClause.thenClause else return elseClause
  }

}
