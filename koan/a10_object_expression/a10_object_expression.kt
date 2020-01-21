import java.util.*

fun getList(): List<Int> {
  val arrayList = arrayListOf(1, 5, 2)
  Collections.sort(arrayList, object : Comparator<Int> {
    override fun compare(x: Int, y: Int) = y - x
  })
  return arrayList
}

fun main(args: Array<String> = arrayOf()) {
  assert(getList() == arrayListOf(5, 2, 1), fun() = "check if it is sorted descending" )
  println("OK")
}

