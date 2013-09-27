package controllers

import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import org.eclipse.jgit.storage.file.FileRepositoryBuilder

object Application extends Controller {

  val repos = new Repositories

  def index = Action {
    Ok(views.html.index(
      repos.names
    ))
  }

  def summary(repoName: String) = Action.async {
    scala.concurrent.Future {
      FileRepositoryBuilder.create(repos.pathFor(repoName))
    }.map { repo =>
      Ok(views.html.summary(repoName)(repo))
    }
  }


}