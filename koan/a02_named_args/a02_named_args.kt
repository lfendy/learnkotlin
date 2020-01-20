fun joinOptions(options: Collection<String>) =
    options.joinToString(prefix= "[", postfix= "]")

fun main(args: Array<String> = arrayOf()) {
  println(joinOptions(listOf("a", "b", "c")))
}

