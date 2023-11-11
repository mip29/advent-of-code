ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code"
  )

val http4sVersion = "1.0.0-M40"

libraryDependencies += "org.http4s" %% "http4s-ember-client" % http4sVersion
