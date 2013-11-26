libraryDependencies ++= Seq(
    "org.eclipse.jgit" % "org.eclipse.jgit" % "3.0.0.201306101825-r",
    "org.mockito" % "mockito-core" % "1.9.5" % "test"
)

sourceDirectory in Test := file("test/scala")

test in Test <<= (test in Test) dependsOn jasmine