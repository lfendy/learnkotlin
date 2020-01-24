class LazyProperty(val initializer: () -> Int) {
  val lazyValue: Int by lazy(initializer)
}

fun main(args: Array<String> = arrayOf()) {
  val lazyProp = LazyProperty( { 42 } )
  println(lazyProp.lazyValue)
  println("OK")
}

