ThisBuild / organization := "io.jasonleehodges"
ThisBuild / organizationName := "Jason Lee Hodges"
ThisBuild / organizationHomepage := Some(url("http://www.jasonleehodges.io/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/jasonleehodges/kotlin-ports"),
    "scm:git@github.com:jasonleehodges/kotlin-ports.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "jasonleehodges",
    name  = "Jason Lee Hodges",
    email = "jasonleehodges@outlook.com",
    url   = url("http://www.jasonleehodges.io")
  )
)

ThisBuild / description := "A port of useful Kotlin functionality to Scala using implicits."
ThisBuild / licenses := List("MIT License" -> new URL("http://www.opensource.org/licenses/mit-license.php"))
ThisBuild / homepage := Some(url("https://github.com/jasonleehodges/kotlin-ports"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

