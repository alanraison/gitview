package controllers

import play.api.Play._
import play.api.Configuration
import models.RepositoryConfig
import java.io.File

/**
 */
class Repositories {
  val baseConfig = configuration.getConfig("gitview.repos")
  val names: Iterable[String] =
    baseConfig.map { _.keys } getOrElse Nil

  def pathFor(repo: String): File = {
    baseConfig.flatMap( _.getConfig(repo))
      .flatMap( _.getString("path") )
      .map( new File(_) )
      .getOrElse(throw new Exception("path not found"))
  }
}
