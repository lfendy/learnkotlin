operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
  return date in first..last
}

fun main(args: Array<String> = arrayOf()) {
  val date = MyDate(2002, 2, 2)
  assert(checkInRange(date, MyDate(2001, 2, 2), MyDate(2003, 2, 2)), { -> "true when in range" })
  assert(checkInRange(date, MyDate(2002, 2, 2), MyDate(2003, 2, 2)), { -> "true when date is same as start" })
  assert(checkInRange(date, MyDate(2001, 2, 2), MyDate(2002, 2, 2)), { -> "true when date is same as endInclusive" })
  assert(!checkInRange(date, MyDate(2002, 2, 3), MyDate(2003, 2, 2)), { -> "false when date is before start" })
  assert(!checkInRange(date, MyDate(2001, 2, 2), MyDate(2002, 2, 1)), { -> "false when date is after endInclusive" })
  println("OK")
}

