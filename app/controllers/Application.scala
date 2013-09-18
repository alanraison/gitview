package controllers

import play.api.mvc._
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import play.api.data._
import play.api.data.Forms._
import models.{RefUpdate, RepoUpdate}

object Application extends Controller {

  val repos = new Repositories

  val updateForm = Form(
    mapping(
      "repoName" -> text,
      "updates" -> seq(mapping(
        "branch" -> text,
        "fromRef" -> text,
        "toRef" -> text
      )(RefUpdate.apply)(RefUpdate.unapply))
    )(RepoUpdate.apply)(RepoUpdate.unapply)
  )

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

  def add = Action {
    Ok(views.html.add(updateForm))
  }

  def refUpdate = Action { implicit req =>
    updateForm.bindFromRequest.fold(
      formWithErrors => BadRequest,
      value => Ok
    )
  }

}