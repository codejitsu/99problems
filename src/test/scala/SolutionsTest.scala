import org.junit.Test
import org.junit.Assert._
import problems.Solutions99._

class SolutionsTest {
  @Test def testP01() {
    assertEquals(8, last(List(1, 1, 2, 3, 5, 8)))
  }
  
  @Test def testP02() {
    assertEquals(5, penultimate(List(1, 1, 2, 3, 5, 8)))
  }
  
  @Test def testP03() {
    assertEquals(2, nth(2, List(1, 1, 2, 3, 5, 8)))
    assertEquals(1, nth(0, List(1, 1, 2, 3, 5, 8)))
    assertEquals(8, nth(5, List(1, 1, 2, 3, 5, 8)))
  }
}