name := "hadoop-aws"

organization := "io.grhodes"

version := "git describe --tags --dirty --always".!!.stripPrefix("v").trim

scalaVersion := "2.11.8"

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache-2.0"))

libraryDependencies ++= Seq(
  "com.google.guava" % "guava" % "11.0.2",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.197",
  "com.amazonaws" % "aws-java-sdk-sts" % "1.11.197",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.3",
  "org.apache.hadoop" % "hadoop-common" % "2.7.3" % Configurations.Provided
)

