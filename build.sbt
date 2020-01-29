enablePlugins(ScalaJSBundlerPlugin)

name := "repro"
scalaVersion := "2.12.8"

libraryDependencies += "io.udash" %%% "udash-core" % "0.8.1"
libraryDependencies += "org.querki" %%% "jquery-facade" % "1.2"


npmDependencies in Compile += "jquery" -> "3.3.1"
npmDependencies in Compile += "jquery-ui-bundle" -> "1.12.1"

(jsSourceDirectories in Compile) += baseDirectory.value / "src" / "main" / "webapp" / "js"

mainClass in Compile := Some("Main")

scalaJSUseMainModuleInitializer := true

webpackBundlingMode := BundlingMode.LibraryOnly()
