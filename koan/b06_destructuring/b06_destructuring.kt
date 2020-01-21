data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

fun isLeapDay(date: MyDate): Boolean {

  // Two ways of destructuring:
  // 1. positional destructuring
	// val (year, month, dayOfMonth) = date

  // 2. using run to destructure, 
  //  will allow for mismatch between index position in class' constructor, because the right part of the statement actually uses variables
  //  however, the position need to be the same between left side of statement and right side
	// val (month, year, dayOfMonth) = date.run { arrayOf(month, year, dayOfMonth) }

	// 29 February of a leap year
	// return year % 4 == 0 && month == 2 && dayOfMonth == 29

  // run     (no send, return last)
  // return run { date.year % 4 == 0 && date.month == 2 && date.dayOfMonth == 29 }

  // with    (send this, return last)
  // return with(date) { year % 4 == 0 && month == 2 && dayOfMonth == 29 }

  // T.run   (extension fun, send this, return last)
  // return date.run { year % 4 == 0 && month == 2 && dayOfMonth == 29 }

  // T.let   (extension fun, send it, return last)
  // return date.let { it.year % 4 == 0 && it.month == 2 && it.dayOfMonth == 29 }

  // T.apply (send this, return this)
  // var toReturn: Boolean
  // date.apply { toReturn = year % 4 == 0 && month == 2 && dayOfMonth == 29 }
  // return toReturn

  // T.also  (send it, return this)
  var toReturn: Boolean
  date.also { toReturn = it.year % 4 == 0 && it.month == 2 && it.dayOfMonth == 29 }
  return toReturn
}

fun main(args: Array<String> = arrayOf()) {
	println(isLeapDay(MyDate(2020, 2, 29)))
}

