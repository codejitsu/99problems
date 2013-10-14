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
  def reverse(list: List[Int]): List[Int] = {
    @tailrec
    def rev(res: List[Int], ls: List[Int]): List[Int] = ls match {
      case Nil => res
      case x :: xs => rev(x :: res, xs)
    }
    
    rev(List(), list)
  }
}