name := "hadoop-aws"

organization := "io.grhodes"

version := "git describe --tags --dirty --always".!!.stripPrefix("v").trim

scalaVersion := "2.11.12"

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "11.0.2",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.283",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.7",
  "org.apache.hadoop" % "hadoop-common" % "2.7.5" % Configurations.Provided
)

