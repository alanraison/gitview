package models

import play.api.libs.json.Json

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 16/09/13
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
case class RefUpdate(branchName: String, fromRef: String, toRef: String)

case class RepoUpdate(repoId: String, refUpdates: Seq[RefUpdate])

object RefUpdate {
  implicit val refUpdateFmt = Json.format[RefUpdate]
}

object RepoUpdate {
  implicit val repoUpdateFmt = Json.format[RepoUpdate]
}
