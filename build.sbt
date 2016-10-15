name := "scala_bulletin_board_system"

version := "1.0"

lazy val `scala_bulletin_board_system` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "commons-dbcp" % "commons-dbcp" % "1.4",
  jdbc,
  cache,
  ws,
  specs2 % Test )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  