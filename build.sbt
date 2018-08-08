import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "tdd-scala",
  version := "0.1.0-SNAPSHOT",
  organization := "co.yuito",
  scalaVersion := "2.12.6",
  scalacOptions := Seq(
    "-deprecation",
    "-feature"
  )
)

lazy val dependencies = Seq(
  "org.scalatest" %% "scalatest"   % "3.0.1"  % "test",
  "org.mockito"   % "mockito-core" % "2.8.9"  % "test"
)

lazy val root = Project(
  "tdd-scala",
  file(".")
).settings(
  libraryDependencies ++= dependencies
)
