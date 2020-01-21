import java.util.*

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    // Collections.sort(arrayList, { x, y -> y - x })
    Collections.sort(arrayList, fun(x: Int, y: Int) = y - x)
    return arrayList
}

fun main(args: Array<String> = arrayOf()) {
  assert(getList() == arrayListOf(5, 2, 1), { -> "check descending sort" })
  println("OK")
}

