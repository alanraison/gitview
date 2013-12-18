package controllers

import play.api.Play._
import java.io.File
import models.RepositorySummary

/**
 */
class Repositories {
  val baseConfig = configuration.getConfig("gitview.repos").get

  val summaries: Iterable[RepositorySummary] = baseConfig.subKeys map { name =>
    RepositorySummary(name, pathFor(name).getAbsolutePath, descriptionFor(name))
  }

  def findGitDir(path: File): File =
    if (path.getName == ".git") {
      path.getParentFile
    } else {
      path
    }

  def descriptionFor(repo: String): String = "No Description file"

  def pathFor(repo: String): File = {
    baseConfig.getConfig(repo)
      .flatMap( _.getString("path") )
      .map( new File(_) )
      .getOrElse(throw new Exception("path not found"))
  }
}
