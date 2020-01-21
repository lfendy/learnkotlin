fun Int.r(): RationalNumber = TODO()
fun Pair<Int, Int>.r(): RationalNumber = TODO()

data class RationalNumber(val numerator: Int, val denominator: Int)

fun main(args: Array<String> = arrayOf()) {
  println(1.r())
}

