fun containsEven(collection: Collection<Int>): Boolean =
  collection.any { it % 2 == 0}

fun main(args: Array<String> = arrayOf()) {
  println(containsEven(listOf(3, 4)))
}

