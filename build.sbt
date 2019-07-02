enablePlugins(ScalaJSBundlerPlugin)

lazy val opexCounter = project.in(file(".")).settings(

	name := "Repro",
	scalaVersion := "2.12.8",

	libraryDependencies ++= Seq(
		"org.scala-js" %%% "scalajs-dom" % "0.9.6",
		"com.lihaoyi" %%% "scalatags" % "0.6.7",
		"be.doeraene" %%% "scalajs-jquery" % "0.9.4"
	),

	npmDependencies in Compile ++= Seq(
		"jquery" -> "2.2.1",
		"jquery-ui" -> "1.12.1",
	),
	
	mainClass in Compile := Some("App"),

	scalaJSUseMainModuleInitializer := true,

	webpackDevServerPort := 3000
)
