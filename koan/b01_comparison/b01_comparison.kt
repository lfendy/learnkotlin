data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
  /* TODO */
  override fun compareTo(other: MyDate): Int {
    return when {
      year  != other.year  -> year - other.year
      month != other.month -> month - other.month
      else                 -> dayOfMonth - other.dayOfMonth
    }
  }
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2

fun main(args: Array<String> = arrayOf()) {
  assert(MyDate(2002, 2, 2) == MyDate(2002, 2, 2), { -> "Same date should be equal" })
  assert(MyDate(2002, 2, 1) < MyDate(2002, 2, 2), { -> "Earlier day of month should be earlier" })
  assert(MyDate(2002, 1, 2) < MyDate(2002, 2, 2), { -> "Earlier month should be earlier" })
  assert(MyDate(2001, 2, 2) < MyDate(2002, 2, 2), { -> "Earlier year should be earlier" })
  println("OK")
}

