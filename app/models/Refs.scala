package models

import play.api.libs.json._

class RefType(val value: String)
object RefType {
  implicit object refFormat extends Format[RefType] {
    def reads(json: JsValue) = json.as[String] match {
      case "branch" => JsSuccess(Branch)
      case "tag" => JsSuccess(Tag)
    }

    def writes(o: RefType) = JsString(o.value)
  }
}
case object Branch extends RefType("branch")
case object Tag extends RefType("tag")

case class RefSummary(name: String, refType: RefType, hash: String, headComment: String)

object RefSummary {
  implicit val refDetailFormat = Json.format[RefSummary]
}