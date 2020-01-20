val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} ${month} \d{4}"""

fun main(args: Array<String> = arrayOf()) {
  println(getPattern().toRegex().containsMatchIn(input = "13 DEC 1984"))
}

