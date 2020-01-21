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
