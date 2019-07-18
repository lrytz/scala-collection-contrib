import ScalaModulePlugin._

scalaModuleSettings

name := "scala-collection-contrib"
version := "0.1.0-SNAPSHOT"

scalaVersionsByJvm in ThisBuild := {
  val v213 = "2.13.0"
  Map(
    8 -> List(v213 -> true),
    11 -> List(v213 -> false),
    12 -> List(v213 -> false))
}

scalacOptions ++= Seq("-opt-warnings", "-language:higherKinds", "-deprecation", "-feature", "-Xfatal-warnings")
scalacOptions in (Compile, doc) ++= Seq("-implicits", "-groups")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v", "-s", "-a")
parallelExecution in Test := false  // why?

homepage := Some(url("https://github.com/scala/scala-collection-contrib"))
licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0"))

libraryDependencies ++= Seq(
  "junit"            % "junit"           % "4.12"   % Test,
  "com.novocode"     % "junit-interface" % "0.11"   % Test,
  "org.openjdk.jol"  % "jol-core"        % "0.9"    % Test
)
