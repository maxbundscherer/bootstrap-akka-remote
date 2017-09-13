name := "bootstrap-akka-remote"
version := "0.1"
scalaVersion := "2.12.3"

val akkaVersion: String       = "2.5.4"
val scalaTestVersion: String  = "3.0.1"

//Akka with akka-remote
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion
)

//ScalaTest
libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

//SBT native packager for docker
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

//Docker settings
dockerExposedPorts := Seq(5150)
mainClass in Compile := Some("com.mb.bootstrap.MainServer")
dockerEntrypoint := Seq("bin/%s" format executableScriptName.value, "-Dconfig.resource=docker.conf")