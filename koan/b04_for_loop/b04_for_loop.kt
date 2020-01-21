operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
  override fun iterator(): Iterator<MyDate> {
    return object: Iterator<MyDate> {
			var currentDate = start
      override fun hasNext() = currentDate <= end
      override fun next(): MyDate {
				val toReturn = currentDate
				currentDate = currentDate.nextDay()
				return toReturn
      }
    }
  }
}


// Does Single Abstract Method conversion work here?
// operator fun MyDate.rangeTo(other: MyDate) = { -> object: Iterator<MyDate> {
//   val start = this
//   val end = other
//  	var currentDate = start
//     override fun hasNext() = currentDate <= end
//     override fun next(): MyDate {
//  		val toReturn = currentDate
//  		currentDate = currentDate.nextDay()
//  		return toReturn
//     }
//   }
// }

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
  for (date in firstDate..secondDate) {
    handler(date)
  }
}

fun main(args: Array<String> = arrayOf()) {
  iterateOverDateRange(
    MyDate(2002, 2, 2),
    MyDate(2002, 2, 12),
    ::println
  )
  println("OK")
}

