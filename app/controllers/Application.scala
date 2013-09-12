package controllers

import play.api.mvc._
import org.eclipse.jgit.storage.file.FileRepositoryBuilder

object Application extends Controller {

  val repos = new Repositories

  def index = Action {
    Ok(views.html.index(
      repos.names
    ))
  }

  def summary(repo: String) = Action {
    Ok(views.html.summary(repo)(
      FileRepositoryBuilder.create(repos.pathFor(repo))
    ))
  }

}