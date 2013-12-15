package models

import play.api.libs.json._

case class RefSummary(name: String, hash: String, headComment: String)

object RefSummary {
  implicit val refDetailFormat = Json.format[RefSummary]
}