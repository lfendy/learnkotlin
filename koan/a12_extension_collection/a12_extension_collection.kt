fun getList(): List<Int> {
  return arrayListOf(1, 5, 2).sortedDescending()//TODO("return the list sorted in descending order")
}

fun main(args: Array<String> = arrayOf()) {
  assert(getList() == arrayListOf(5, 2, 1), { -> "check list is descending" })
  println("OK")
}

