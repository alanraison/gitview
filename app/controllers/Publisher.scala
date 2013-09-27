package controllers

import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._
import play.api.libs.iteratee._
import models.RepoUpdate

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/09/13
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 */
object Publisher extends Controller {

  def refUpdate() = Action(parse.json) { json =>
    json.body.validate[RepoUpdate].map { repoUpdate =>
      Ok(Json.obj("status" -> "ok"))
    }.recoverTotal(e => BadRequest(JsError.toFlatJson(e)))
  }

  def events() = TODO

  def events2() = {
    val in = Iteratee.foreach[JsObject](_ => Unit)
    val out = Enumerator(Json.obj("event" -> "test")).andThen(Enumerator.eof)
    (in, out)
  }
}
