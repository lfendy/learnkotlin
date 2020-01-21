fun Int.r(): RationalNumber = RationalNumber(this, 1)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

data class RationalNumber(val numerator: Int, val denominator: Int)

fun main(args: Array<String> = arrayOf()) {
  assert(5.r() == RationalNumber(5 ,1))
  assert(Pair(1,2).r() == RationalNumber(1 ,2))
  println("OK")
}

