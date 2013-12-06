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
  
  //P08
  def compress(list: List[Symbol]): List[Symbol] = {
    @tailrec
    def comp(lst: List[Symbol], acc: List[Symbol]): List[Symbol] = lst match {
      case Nil => acc
      case x::Nil => acc :+ x
      case x::y::xt if x == y => comp(y::xt, acc)
      case x::y::xt => comp(y::xt, acc :+ x)
    }
    
    comp(list, List())
  }
  
  //P09
  def pack(list: List[Symbol]): List[List[Symbol]] = {
    @tailrec
    def _pack(lst: List[Symbol], current: Symbol, acc: List[Symbol], 
        res: List[List[Symbol]]): List[List[Symbol]] = lst match {
      case Nil => res
      case x::Nil if x == current => res :+ (acc :+ x)
      case x::Nil if x != current => res :+ acc :+ List(x)
      case x::xs if x == current => _pack(xs, current, acc :+ x, res)
      case x::xs if x != current => _pack(xs, x, List(x), res :+ acc)
    }
    
    if (list.isEmpty) Nil
    else _pack(list.tail, list.head, List(list.head), List())
  }
  
  def pack2(list: List[Symbol]): List[List[Symbol]] = list match {
    case Nil => Nil
    case x::xs => {
      list.takeWhile(_ == x) :: pack2(list.dropWhile(_ == x))
    }
  }
}