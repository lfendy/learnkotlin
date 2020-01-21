import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

data class TimeIntervals(val timeInterval: TimeInterval, val number: Int)
operator fun TimeInterval.times(number: Int): TimeIntervals = TimeIntervals(this, number)

// which one is idiomatic? using when..is or using traditional overloading?
operator fun MyDate.plus(timeInterval: Any): MyDate {
  return when(timeInterval) {
    is TimeInterval -> this.addTimeIntervals(timeInterval, 1)
    is TimeIntervals -> this.addTimeIntervals(timeInterval.timeInterval, timeInterval.number)
    else -> throw IllegalArgumentException("wtf")
  }
}

fun main(args: Array<String> = arrayOf()) {
  var date = MyDate(2002, 2, 2)

  var datePlusYearWeek = date + YEAR + WEEK
  println(datePlusYearWeek)
  assert(datePlusYearWeek == MyDate(2003, 2, 9))

  var datePlus2Years3Weeks5Days = date + YEAR * 2 + WEEK * 3 + DAY * 5
  println(datePlus2Years3Weeks5Days)
  assert(datePlus2Years3Weeks5Days == MyDate(2004, 2, 28))
}

