package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models.{RepoUpdate, RefUpdate}
import play.api.Logger

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 19/09/13
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
object Tests extends Controller {

  val updateForm = Form(
    mapping(
      "repoName" -> text,
      "updates" -> seq(mapping(
        "branchName" -> text,
        "fromRef" -> text,
        "toRef" -> text
      )(RefUpdate.apply)(RefUpdate.unapply))
    )(RepoUpdate.apply)(RepoUpdate.unapply)
  )

  def add = Action {
    Ok(views.html.add(updateForm))
  }

}
