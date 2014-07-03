package problems {
  class S99Int(val start: Int) {

    def dividers = for(j <- Range(1, start + 1) if start % j == 0) yield j

    def isPrime = dividers.length == 2
  }

  object S99Int {
    import scala.language.implicitConversions
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
