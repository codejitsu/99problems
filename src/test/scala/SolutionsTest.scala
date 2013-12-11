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
  
  @Test def testP09() {
    assertEquals(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)), 
        List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
    assertEquals(pack2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)), 
        List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }
  
  @Test def testP09_2() {
    assertEquals(pack(List('a, 'b, 'c, 'a, 'd, 'e)), 
        List(List('a), List('b), List('c), List('a), List('d), List('e)))
    assertEquals(pack2(List('a, 'b, 'c, 'a, 'd, 'e)), 
        List(List('a), List('b), List('c), List('a), List('d), List('e)))
  }
  
  @Test def testP09_3() {
    assertEquals(pack(List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a)), 
        List(List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a)))
    assertEquals(pack2(List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a)), 
        List(List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a)))        
  } 
  
  @Test def testP09_4() {
    assertEquals(pack(List('g, 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e, 'f)), 
        List(List('g), List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e), List('f)))
    assertEquals(pack2(List('g, 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e, 'f)), 
        List(List('g), List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e), List('f)))
  }  
  
  @Test def testP10() {
    assertEquals(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)), 
        encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
  
  @Test def testP10_1() {
    assertEquals(List((4,'a)), 
        encode(List('a, 'a, 'a, 'a)))
  }
  
  @Test def testP10_2() {
    assertEquals(List(), 
        encode(List()))
  }
  
  @Test def testP10_3() {
    assertEquals(List((1,'a), (1,'b), (1,'c), (1,'a), (1,'d), (1,'e)), 
        encode(List('a, 'b, 'c, 'a, 'd, 'e)))
  }  
  
  @Test def testP11() {
    assertEquals(List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)), 
        encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
  
  @Test def testP12() {
    assertEquals(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e), 
        decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  }
  
  @Test def testP13() {
    assertEquals(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)), 
        encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
  
  @Test def testP13_1() {
    assertEquals(List((4,'a)), 
        encodeDirect(List('a, 'a, 'a, 'a)))
  }
  
  @Test def testP13_2() {
    assertEquals(List(), 
        encodeDirect(List()))
  }
  
  @Test def testP13_3() {
    assertEquals(List((1,'a), (1,'b), (1,'c), (1,'a), (1,'d), (1,'e)), 
        encodeDirect(List('a, 'b, 'c, 'a, 'd, 'e)))
  }    
}