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
  
  @Test def testP04() {
    assertEquals(0, length(List()))
    assertEquals(6, length(List(1, 1, 2, 3, 5, 8)))
    
    assertEquals(0, lengthTailrec(List()))
    assertEquals(6, lengthTailrec(List(1, 1, 2, 3, 5, 8)))    
  }
  
  @Test def testP05() {
	assertEquals(List(), reverse(List()))
    assertEquals(List(8, 5, 3, 2, 1, 1), reverse(List(1, 1, 2, 3, 5, 8)))
  }
  
  @Test def testP06() {
    assertTrue(isPalindrome(List()))
    assertTrue(isPalindrome(List(1, 2, 3, 2, 1)))
  }
  
  @Test def testP07() {
    assertEquals(List(1, 1, 2, 3, 5, 8), flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }
  
  @Test def testP08() {
    assertEquals(List('a, 'b, 'c, 'a, 'd, 'e), compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}