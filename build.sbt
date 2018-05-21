import sys.process.Process

name := "hadoop-aws"

organization := "io.grhodes"

version := Process("git describe --tags --dirty --always").lineStream_!.head.stripPrefix("v").trim

scalaVersion := "2.11.12"

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))
homepage := Some(url("https://github.com/grahamar/hadoop-aws"))

scmInfo := Some(
  ScmInfo(
    browseUrl = url("https://github.com/grahamar/hadoop-aws"),
    connection = "scm:git:git@github.com:grahamar/hadoop-aws.git"
  )
)

developers := List(
  Developer(
    id    = "grahamar",
    name  = "Graham Rhodes",
    email = "postmaster@grhodes.io",
    url   = url("https://github.com/grahamar")
  )
)

publish := PgpKeys.publishSigned.value
publishLocal := PgpKeys.publishLocalSigned.value
publishMavenStyle := true
pomIncludeRepository := { _ => false }

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "11.0.2",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.283",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.7",
  "org.apache.hadoop" % "hadoop-common" % "2.8.3" % Provided
)
