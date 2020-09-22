lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.5"

ThisBuild / organization := "earthly.dev"
ThisBuild / scalaVersion := "2.12.1"
ThisBuild / version      := "1.0"

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    Defaults.itSettings,
    libraryDependencies += scalatest % "it,test"
  )