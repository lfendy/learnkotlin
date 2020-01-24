import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
	var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

	var timeInMillis: Long? = null

	override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
		return timeInMillis!!.toDate()
	}

	override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
		timeInMillis = value.toMillis()
	}
}


fun main(args: Array<String> = arrayOf()) {
	val d = D()
	d.date = MyDate(2014, 1, 13)
	val message = "The methods 'getValue' and 'setValue' are implemented incorrectly"
	assert(2014 == d.date.year, { message })
	assert(1 == d.date.month, { message })
	assert(13 == d.date.dayOfMonth, { message })
	println("OK")
}

