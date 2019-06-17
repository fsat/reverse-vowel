import scalariform.formatter.preferences._


scalariformPreferences in ThisBuild := scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AllowParamGroupsOnNewlines, true)

//wartremoverErrors in (Compile, compile) := Warts.unsafe.filterNot(_ ==  Wart.DefaultArguments)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

scalaVersion := "2.12.8"
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked")

