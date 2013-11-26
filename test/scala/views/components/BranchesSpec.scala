package views.components

import org.specs2.mutable._
import org.specs2.mock._
import org.eclipse.jgit.lib.{Ref, Repository}
import scala.collection.JavaConversions._
import org.specs2.specification.Scope
import org.specs2.matcher.XmlMatchers


/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 28/09/13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
class BranchesSpec extends Specification with Mockito with XmlMatchers {
  "Branches view" should {
    "display branches" in new MockTwoBranchesScope {
      val branchesView = views.html.components.branches(mockRepository).body

      branchesView must
        contain ("test-branch-a") and
        contain ("test-branch-b")
    }
    "show the current branch" in new MockTwoBranchesScope {
      mockRepository.getFullBranch returns "test-branch-b"

      val branchesView = views.html.components.branches(mockRepository).body

      // the li with the text "test-branch-b" must have class HEAD
      //branchesView must \\("li", "class" -> "HEAD") \> "test-branch-b"
      todo
    }
  }
}

trait MockRepositoryScope extends Scope with Mockito {
  val mockRepository = mock[Repository]
}

trait MockTwoBranchesScope extends MockRepositoryScope {
  val mockRef1 = mock[Ref]
  val mockRef2 = mock[Ref]
  mockRepository.getAllRefs returns Map("test-branch-a" -> mockRef1, "test-branch-b" -> mockRef2)
}
