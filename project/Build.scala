import sbt._
import Keys._
import play.Project._
import com.gu.SbtJasminePlugin._

object ApplicationBuild extends Build {

  val appName         = "gitview"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
  )


  val main = play.Project(appName, appVersion, appDependencies)
    .settings(jasmineSettings : _*)
    .settings(
    // Add your own project settings here
    appJsDir <+= (resourceManaged in Compile) { _ / "public" / "javascripts" },
    appJsLibDir <+= baseDirectory { _ / "public" / "javascripts" },
    jasmineTestDir <+= baseDirectory { _ / "test" / "js" },
    jasmineConfFile <+= baseDirectory { _ / "test" / "js" / "jasmine-config.js" },
    jasmineRequireJsFile <+= baseDirectory { _ / "test" / "js" / "lib" / "require-2.1.9.min.js" },
    jasmineRequireConfFile <+= baseDirectory { _ / "test" / "js" / "require.conf.js" }
  )

}
