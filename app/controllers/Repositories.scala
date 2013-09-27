package controllers

import play.api.Play._
import java.io.File

/**
 */
class Repositories {
  val baseConfig = configuration.getConfig("gitview.repos").get

  val names: Iterable[String] = baseConfig.subKeys

  def findGitDir(path: File): File =
    if (path.getName == ".git") {
      path.getParentFile
    } else {
      path
    }

  def pathFor(repo: String): File = {
    baseConfig.getConfig(repo)
      .flatMap( _.getString("path") )
      .map( new File(_) )
      .getOrElse(throw new Exception("path not found"))
  }
}
