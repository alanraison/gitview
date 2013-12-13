package models

import play.api.libs.json._

/**
 * Created by alan on 13/12/13.
 */
case class Branches(branches: List[String], head: String)

object Branches {
  implicit val branchesFormat = Json.format[Branches]
}