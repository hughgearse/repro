lazy val root = project.in(file("."))
  .settings(
    name := "repro",
    version := "1.0",
    scalaVersion := "2.11.8",
    unmanagedSourceDirectories in Compile +=
			baseDirectory.value / ".." / "ext1" /  "src" / "main" / "scala",
    unmanagedSourceDirectories in Compile +=
      baseDirectory.value / ".." / "ext2" /  "src" / "main" / "scala"
  )

