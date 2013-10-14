package problems

import scala.annotation.tailrec

object Solutions99 {
  //P01
  def last(list: List[Int]): Int = list match {
    case x :: Nil => x
    case x :: xs => last(xs)
    case _ => throw new IllegalStateException
  }
  
  //P02
  def penultimate(list: List[Int]): Int = list match {
    case x :: _ :: Nil => x
    case x :: _ :: xs => penultimate(xs)
    case _ => throw new IllegalStateException
  }
  
  //P03
  def nth(n: Int, list: List[Int]): Int = {
    if (list.isEmpty) throw new IllegalStateException
    else n match {
      case 0 => list.head
      case _ => nth(n - 1, list.tail)
    }
  }
  
  //P04
  def length(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: xs => 1 + length(xs)
  }
  
  //P04 tail recursive
  def lengthTailrec(list: List[Int]): Int = {
    @tailrec
    def len(res: Int, ls: List[Int]): Int = ls match {
      case Nil => res
      case x :: xs => len(res + 1, xs) 
    }
    
    len(0, list)
  }
  
  //P05
  def reverse[A](list: List[A]): List[A] = {
    @tailrec
    def rev(res: List[A], ls: List[A]): List[A] = ls match {
      case Nil => res
      case x :: xs => rev(x :: res, xs)
    }
    
    rev(List(), list)
  }
  
  //P06
  def isPalindrome(list: List[Int]): Boolean = list == reverse(list)
  
  //P07
  def flatten(list: List[Any]): List[Any] = {
    @tailrec
	def concat[A](list1: List[A], list2: List[A]): List[A] = (list1, list2) match {
	  case (Nil, Nil) => Nil
	  case (x :: xs, Nil) => list1
	  case (Nil, x :: xs) => list2
	  case (ls, x :: xs) => concat(ls :+ x, xs)
	}
    
    @tailrec
    def flat(res: List[Any], ls: List[Any]): List[Any] = ls match {
	  case Nil => res
	  case x :: xs => x match {
	    case l: List[Any] => flat(concat(res, flatten(l)), xs)
	    case a: Any => flat(concat(res, List(x)), xs)
	  }
	}
    
    flat(List(), list)
  }
}