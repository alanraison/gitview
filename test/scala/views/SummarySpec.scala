package views

import org.specs2.mutable.Specification
import org.specs2.mock._
import org.eclipse.jgit.lib.Repository

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 28/09/13
 * Time: 21:34
 * To change this template use File | Settings | File Templates.
 */
class SummarySpec extends Specification with Mockito {
  "Summary view" should {
    "list branches" in {
      val mockRepository = mock[Repository]
      //mockRepository.getAllRefs returns "test-branch"
      val page = views.html.summary("test")(mockRepository)
      todo
    }
  }
}
