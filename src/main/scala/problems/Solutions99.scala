package problems

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
}