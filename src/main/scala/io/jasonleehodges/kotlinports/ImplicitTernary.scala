package io.jasonleehodges.kotlinports


/** An implicit class that mimics the ternary operator from Java.
  *
  * Example: val obj = (true) ?? "true" :: "false"
  *
  * The variable obj will be assigned the string "true".
  * */
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
