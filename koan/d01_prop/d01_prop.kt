class PropertyExample() {
  var counter = 0
  var propertyWithCounter: Int? = null
    set(value) {
      counter++
      field = value
    }
}

fun main(args: Array<String> = arrayOf()) {
  println("OK")
  val ex = PropertyExample()
  println(ex.counter)
  ex.propertyWithCounter = 10
  println("set ${ex.counter} times, prop is now ${ex.propertyWithCounter}")
  ex.propertyWithCounter = 10
  println("set ${ex.counter} times, prop is now ${ex.propertyWithCounter}")
  ex.propertyWithCounter = 20
  println("set ${ex.counter} times, prop is now ${ex.propertyWithCounter}")

}

