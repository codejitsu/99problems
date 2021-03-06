import org.junit.Assert._
import org.junit.Test
import problems.S99Int._
import problems.Solutions99._

import scala.language.implicitConversions

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
  
  @Test def testP14() {
    assertEquals(List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd), duplicate(List('a, 'b, 'c, 'c, 'd)))
  }
  
  @Test def testP15() {
    assertEquals(List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd), 
        duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  }
  
  @Test def testP15_1() {
    assertEquals(List('a, 'b, 'c, 'c, 'd), 
        duplicateN(1, List('a, 'b, 'c, 'c, 'd)))
  }  
  
  @Test def testP16() {
    assertEquals(List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k), 
        drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP16_1() {
    assertEquals(List('a, 'c, 'e, 'g, 'i, 'k), 
        drop(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP16_2() {
    assertEquals(List(), 
        drop(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }    
  
  @Test def testP17() {
    assertEquals((List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)),
        split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP17_1() {
    assertEquals((List(), List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)),
        split(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP17_2() {
    assertEquals((List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), List()),
        split(11, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP17_3() {
    assertEquals((List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k), List()),
        split(100, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }  
  
  @Test def testP18() {
    assertEquals(List('d, 'e, 'f, 'g), 
        slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP19_1() {
    assertEquals(List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c), 
        rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP19_2() {
    assertEquals(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i),
        rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
  
  @Test def testP19_3() {
    assertEquals(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i),
        rotate(0, List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
  }
  
  @Test def testP19_4() {
    assertEquals(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i),
        rotate(11, List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
  }
  
  @Test def testP19_5() {
    assertEquals(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i),
        rotate(-11, List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)))
  }      
  
  @Test def testP20() {
    assertEquals((List('a, 'c, 'd), Some('b)), removeAt(1, List('a, 'b, 'c, 'd)))
  }
  
  @Test def testP20_1() {
    assertEquals((List('a, 'b, 'c), Some('d)), removeAt(3, List('a, 'b, 'c, 'd)))
  }
  
  @Test def testP20_2() {
    assertEquals((List('b, 'c, 'd), Some('a)), removeAt(0, List('a, 'b, 'c, 'd)))
  }  
  
  @Test def testP21() {
    assertEquals(List('a, 'new, 'b, 'c, 'd), insertAt('new, 1, List('a, 'b, 'c, 'd)))
  }
  
  @Test def testP21_1() {
    assertEquals(List('new, 'a, 'b, 'c, 'd), insertAt('new, 0, List('a, 'b, 'c, 'd)))
  }
  
  @Test def testP21_2() {
    assertEquals(List('a, 'b, 'c, 'new, 'd), insertAt('new, 3, List('a, 'b, 'c, 'd)))
  }   
  
  @Test def testP22() {
    assertEquals(List(4, 5, 6, 7, 8, 9), range(4, 9))
  }
  
  @Test def testP22_1() {
    assertEquals(List(4), range(4, 4))
  }

  @Test def testP22_2() {
    assertEquals(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), range(1, 10))
  }
  
  @Test def testP23_1() {
    assertEquals(List(), randomSelect(0, List('a, 'b, 'c, 'd)))
  }
  
  @Test def testP23_2() {
    assertEquals(1, randomSelect(1, List('a, 'b, 'c, 'd)).length)
  }  
  
  @Test def testP23_3() {
    assertEquals(1000, randomSelect(1000, List('a, 'b, 'c, 'd)).length)
  }    
  
  @Test def testP24_1() {
    assertEquals(10, lotto(10, 50).length)
  }

  @Test def testP24_2() {
    assertEquals(10, lotto(10, 50).toSet.size)
  }
  
  @Test def testP24_3() {
    assertFalse(lotto(10, 50) == lotto(10, 50))
  }
  
  @Test def testP24_4() {
    assertFalse(lotto(50, 50) == lotto(50, 50))
  }    

  @Test def testP24_5() {
    assertTrue(lotto(50, 50).length == lotto(50, 50).length)
  }  
  
  @Test def testP25_1() {
    assertEquals(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)).length, randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)).length)
  }
  
  @Test def testP25_2() {
    val input = List('a, 'b, 'c, 'd, 'e, 'f)
    assertFalse(randomPermute(input) == input)
  }  

  @Test def testP25_3() {
    val input = List('a, 'b, 'c, 'd, 'e, 'f)
    assertTrue(randomPermute(input).length == input.length)
  }
  
  @Test def testP25_4() {
    assertFalse(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)).isEmpty)
  }  
  
  @Test def testP26_1() {
    assertEquals(combinations(1, List('a, 'b, 'c)).toSet, List(List('a), List('b), List('c)).toSet)
  }
  
  @Test def testP26_2() {
    assertEquals(combinations(2, List('a, 'b, 'c)).toSet, List(List('a, 'b), List('b, 'c), List('a, 'c)).toSet)
  }
  
  @Test def testP26_3() {
    assertEquals(combinations(3, List('a, 'b, 'c)).toSet, List(List('a, 'b, 'c)).toSet)
  }
  
  @Test def testP26_4() {
    assertEquals(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'l)).length, 220)
  }    
  
  @Test def testP27_1() {
    assertEquals(group3(2, 3, 4, List("A", "B", "C")), Nil)
  }
  
  @Test def testP27_2() {
    assertEquals(group3(2, 3, 4, List("A", "B", "C", "D", "E", "F", "G", "H")), Nil)
  }  
  
  @Test def testP27_3() {
    assertTrue(group3(2, 3, 4, List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) contains 
        List(List("Aldo", "Beat"), List("Carla", "David", "Evi"), List("Flip", "Gary", "Hugo", "Ida")))
  }
  
  @Test def testP27_4() {
    assertTrue(group3(2, 2, 5, List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) contains 
        List(List("Aldo", "Beat"), List("Carla", "David"), List("Evi", "Flip", "Gary", "Hugo", "Ida")))
  }  
  
  @Test def testP28_1() {
    assertEquals(Nil, lsort(Nil))
  }
  
  @Test def testP28_2() {
    assertEquals(List(List('a, 'b)), lsort(List(List('a, 'b))))
  }  
  
  @Test def testP28_3() {
    assertEquals(List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)), 
        lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }
  
  @Test def testP28_4() {
    assertEquals(List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n)),
        lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }

  @Test def testP31() {
    assertTrue(997.isPrime)
  }

  @Test def testP31_2() {
    assertFalse(4.isPrime)
  }

  @Test def testP31_3() {
    assertTrue(7.isPrime)
  }
}