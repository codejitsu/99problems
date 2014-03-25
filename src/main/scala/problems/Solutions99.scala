package problems

import scala.annotation.tailrec
import scala.util.Random

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
  
  //P10
  def encode(list: List[Symbol]): List[(Int, Symbol)] = pack(list) map (x => (x.length, x.head))
  
  def encode2(list: List[Symbol]): List[(Int, Symbol)] = {
    @tailrec
    def _enc(lst: List[List[Symbol]], acc: List[(Int, Symbol)]): List[(Int, Symbol)] = lst match {
      case Nil => acc
      case x::xs => _enc(xs, acc :+ (x.length, x.head))
    }
    
    _enc(pack(list), Nil)
  }
  
  //P11
  def encodeModified(list: List[Symbol]): List[Any] = 
    encode(list) map {
     case x: (Int, Symbol) if x._1 > 1 => x
     case x: (Int, Symbol) => x._2
    }
  
  //P12
  def decode(list: List[(Int, Symbol)]): List[Symbol] = list flatMap {x => List.fill(x._1)(x._2)}
  
  def decode2(list: List[(Int, Symbol)]): List[Symbol] = {
    @tailrec
    def repeat(n: Int, s: Symbol, acc: List[Symbol]): List[Symbol] = {
      if (n == 0) acc
      else repeat(n - 1, s, s :: acc)
    }
    
    if (list.isEmpty) Nil
    else {
      repeat(list.head._1, list.head._2, List()) ::: decode2(list.tail)
    }
  }
  
  //P13
  def encodeDirect(list: List[Symbol]): List[(Int, Symbol)] = {
    @tailrec
    def enc(list: List[Symbol], n: Int, s: Symbol, acc: List[(Int, Symbol)]): List[(Int, Symbol)] = list match {
      case Nil => acc :+ (n, s)
      case x::xs if x == s => enc(xs, n + 1, s, acc)
      case x::xs if x != s => enc(xs, 1, x, acc :+ (n, s))
    }
    
    if (list.isEmpty) Nil
    else enc(list.tail, 1, list.head, List())
  }
  
  //P14
  def duplicate(list: List[Symbol]): List[Symbol] = list match {
      case Nil => Nil
      case x::xs => x::x::duplicate(xs)
  }
  
  //P15
  def duplicateN(n: Int, list: List[Symbol]): List[Symbol] = list flatMap (List.fill(n)(_))
  
  //P16
  def drop(n: Int, list: List[Symbol]): List[Symbol] = {
    @tailrec
    def dr(lst: List[Symbol], current: Int, res: List[Symbol]): List[Symbol] = lst match {
      case Nil => res
      case x::xs if current < n => dr(xs, current + 1, res :+ x)
      case x::xs => dr(xs, 1, res)
    }
    
    dr(list, 1, List())
  }
  
  //P17
  def split(n: Int, list: List[Symbol]): (List[Symbol], List[Symbol]) = (list.take(n), list.drop(n))
  
  def split2(n: Int, list: List[Symbol]): (List[Symbol], List[Symbol]) = list.splitAt(n)
  
  //P18
  def slice(from: Int, to: Int, list: List[Symbol]): List[Symbol] = 
    list.zipWithIndex.dropWhile(_._2 < from).takeWhile(_._2 < to) map { case (x, i) => x}
  
  def slice2(from: Int, to: Int, list: List[Symbol]): List[Symbol] = list.slice(from, to)
  
  //P19
  @tailrec
  def rotate(n: Int, list: List[Symbol]): List[Symbol] = n match {
    case 0 => list
    case x if x > 0 => rotate(n - 1, list.tail :+ list.head)
    case x if x < 0 => rotate(n + 1, list.last :: list.take(list.length - 1))
  }
  
  //P20
  def removeAt(n: Int, list: List[Symbol]): (List[Symbol], Option[Symbol]) = {
	  if (n < 0) (list, None)
	  else if (list.isEmpty) (list, None)
	  else if (n > list.length) (list, None)
	  else {
	    val (l, r) = list.splitAt(n)
	    (l ::: r.tail, Some(list(n)))
	  }
  }
  
  //P21
  def insertAt(elem: Symbol, n: Int, list: List[Symbol]): List[Symbol] = {
    if (list.isEmpty) list
	else if (n < 0) list
    else if (n > list.length) list
    else if (n == 0) elem :: list
    else list.head :: insertAt(elem, n - 1, list.tail)
  }
  
  //P22
  def range(left: Int, right: Int): List[Int] = (left, right) match {
    case (_, _) if left == right => List(left)
    case (_, _) if left > right => List()
    case _ => left :: range(left + 1, right)
  }
  
  //P23
  def randomSelect(count: Int, list: List[Symbol]) = {
    @tailrec
    def randomHelper(count: Int, list: List[Symbol], acc: List[Symbol], random: Random): List[Symbol] = count match {
      case 0 => acc
      case _ => randomHelper(count - 1, list, list(random.nextInt(list.length)) :: acc, random)
    }
    
    randomHelper(count, list, List(), new Random)
  }
}