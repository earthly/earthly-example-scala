import org.scalatest.FlatSpec

class ListFlatSpec extends FlatSpec {
  "An empty List" should "have size 0" in {
    assert(List.empty.size == 0)
  }
}