enablePlugins(ScalaJSBundlerPlugin)

name := "Reproduce"
scalaVersion := "2.12.8"

npmDependencies in Compile += "bootstrap" -> "3.4.1"
