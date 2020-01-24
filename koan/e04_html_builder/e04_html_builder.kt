fun renderProductTable(): String {
  return html {
    table {
      tr(color = getTitleColor()) {
        td {
          text("Product")
        }
        td {
          text("Price")
        }
        td {
          text("Popularity")
        }
      }
      val products = getProducts()
      for ((i, p) in products.withIndex()) {
        tr {
          td(color = getCellColor(i, 1)) {
            text(p.description)
          }
          td(color = getCellColor(i, 2)) {
            text(p.price)
          }
          td(color = getCellColor(i, 3)) {
            text(p.popularity)
          }
        }
      }
    }
  }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"

fun main(args: Array<String> = arrayOf()) {
  println(renderProductTable())
  println("OK")
}

