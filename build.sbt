name := "hadoop-aws"

organization := "io.grhodes"

version := "git describe --tags --dirty --always".!!.stripPrefix("v").trim

scalaVersion := "2.11.8"

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-s3" % "1.10.68",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.3",
  "org.apache.hadoop" % "hadoop-common" % "2.7.2" % Configurations.Provided
)

