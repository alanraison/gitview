package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import models.{RefUpdate, RepoUpdate}

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

  def update() = Action { req =>
    req.body.asJson.map { json =>
      json.validate[RepoUpdate].map { repoUpdate =>
        Ok(Json.obj("status" -> "ok"))
      }.recoverTotal(e => BadRequest(JsError.toFlatJson(e)))
    }.getOrElse(
      BadRequest(Json.obj("status" -> "Error", "message" -> "Expected Json Data"))
    )
  }

}