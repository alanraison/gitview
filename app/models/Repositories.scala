package models

import play.api.libs.json.Json

case class RepositorySummary(name: String, path: String, description: String)

object RepositorySummary {
  implicit val repositorySummaryFormat = Json.format[RepositorySummary]
}
