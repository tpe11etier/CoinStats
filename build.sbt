name := "CoinStats"

version := "0.1"

scalaVersion := "2.13.5"

scalacOptions ++= Seq("-deprecation", "-feature", "-language:postfixOps")

libraryDependencies ++= Seq("com.lihaoyi" %% "requests" % "0.6.5",
  "com.lihaoyi" %% "upickle" % "1.3.0",
  "org.scalactic" %% "scalactic" % "3.2.5",
  "org.scalatest" %% "scalatest" % "3.2.5" % "test",
  "org.typelevel" %% "cats-core" % "2.3.0",
  "org.typelevel" %% "kittens" % "2.2.1",
  "com.lihaoyi" %% "pprint" % "0.5.6"
)
