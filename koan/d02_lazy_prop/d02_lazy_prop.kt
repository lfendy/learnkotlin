class LazyProperty(val initializer: () -> Int) {
  var value: Int? = null

  val lazy: Int
  get() {
    if(value == null) {
      value = initializer()
    }
    return value!!
  }
}

fun main(args: Array<String> = arrayOf()) {
  val lazyProp = LazyProperty( { 42 } )
  println(lazyProp.lazy)
  println("OK")
}

