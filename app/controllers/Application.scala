package controllers

import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import models.{Branch, Tag, RepositorySummary, RefSummary}
import play.api.libs.json._
import scala.collection.JavaConversions._

object Application extends Controller {

  val repos = new Repositories

  def index = Action {
    Ok(views.html.index(
      repos.summaries
    ))
  }

  def allRepos() = Action {
    Ok(Json.toJson(repos.summaries))
  }

  def summary(repoName: String) = Action.async {
    scala.concurrent.Future {
      FileRepositoryBuilder.create(repos.pathFor(repoName))
    }.map { repo =>
      Ok(views.html.summary(repoName)(repo)(repos.summaries))
    }
  }

  def branches(repoName: String) = Action.async {
    scala.concurrent.Future {
      FileRepositoryBuilder.create(repos.pathFor(repoName))
    }.map { repo =>
      Ok(Json.toJson(repo.getAllRefs.keySet.filter { _.startsWith("refs/") }.
        map { ref =>
          val refType = if (ref.startsWith("refs/tags")) Tag else Branch
          RefSummary(ref,refType,"","TODO")
        }
      ))
    }
  }
}