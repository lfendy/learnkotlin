fun main(args: Array<String> = arrayOf()) {

  // Intro
  println("==Introduction==")
  println(shop.getSetOfCustomers())

  // Filter Map
  println("==Filtermap==")
  println(shop.getCitiesCustomersAreFrom())
  println(shop.getCustomersFrom(Canberra))

  // All Any Other Predicates
  println("==all any preds==")
  println(shop.checkAllCustomersAreFrom(Canberra))
  println(shop.hasCustomerFrom(Canberra))
  println(shop.countCustomersFrom(Canberra))
  println(shop.findAnyCustomerFrom(Canberra))

  // Flatmap
  println("==Flatmap==")
  println(shop.customers.find { it.name == "Lucas" }?.orderedProducts)
  println(shop.allOrderedProducts)

  // Max min
  println("==Max min==")
  println(shop.getCustomerWithMaximumNumberOfOrders())
  println(shop.customers.find { it.name == lucas }?.getMostExpensiveOrderedProduct())

  // Sort
  println(shop.getCustomersSortedByNumberOfOrders())

  // Sum
  println(shop.customers.find { it.name == lucas }?.getTotalOrderPrice())

  // GroupBy
  println(shop.groupCustomersByCity())

  // Partition
  println(shop.getCustomersWithMoreUndeliveredOrdersThanDelivered())

  // Fold
  println(shop.getSetOfProductsOrderedByEveryCustomer())

  // Compound Tasks
  println(shop.customers.find { it.name == lucas }?.getMostExpensiveOrderedProduct())
  println(shop.getNumberOfTimesProductWasOrdered(idea))




  println("OK")
}


////// Introduction
// Implement an extension function Shop.getSetOfCustomers()
fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

////// Filter Map
// Implement extension functions Shop.getCitiesCustomersAreFrom()
// and Shop.getCustomersFrom() using functions map and filter.

// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = customers.map { it.city }.toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter(FromCity(city))

fun FromCity(city: City): (Customer) -> Boolean = { it.city == city }

////// All Any other predicates
// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all(FromCity(city))

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = customers.any(FromCity(city))

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = customers.count(FromCity(city))

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.find(FromCity(city))

////// Flatmap
// Return all products this customer has ordered
val Customer.orderedProducts: Set<Product> get() {
   return orders.flatMap { it.products }.toSet()
}

// Return all products that were ordered by at least one customer
val Shop.allOrderedProducts: Set<Product> get() {
  return customers.flatMap { it.orderedProducts }.toSet()
}

////// Max Min
// Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = customers.maxBy { it.orders.size }

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? = orders.flatMap { it.products }.maxBy { it.price }

////// Sort
// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = customers.sortedBy { it.orders.size }

////// Sum
// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
// fun Customer.getTotalOrderPrice(): Double = orders.sumByDouble { it.products.sumByDouble { it.price } }
fun Customer.getTotalOrderPrice(): Double = orders.flatMap { it.products }.sumByDouble { it.price }

////// GroupBy
// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }

////// Partition
// Return customers who have more undelivered orders than delivered
// fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
//   val (moreUndelivered, _) = customers.partition {
//     it.orders.filter { !it.isDelivered }.size > it.orders.filter { it.isDelivered }.size
//   }
//   return moreUndelivered.toSet()
// }

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
  return customers.filter {
    val (delivered, undelivered) = it.orders.partition { it.isDelivered }
    undelivered.size > delivered.size
  }.toSet()
}

////// Fold
// Return the set of products that were ordered by every customer
// fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
//   return customers.
//     flatMap { it.orders }.
//     flatMap { it.products }.
//     toSet().
//     fold(mutableListOf<Product>(), {
//       acc, e ->
//         if (customers.all { it.orders.flatMap { it.products }.any { it == e } }) {
//           acc.add(e)
//         }
//         acc
//     }).toSet()
// }

// fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
//   return customers.
//     flatMap { it.orders }.
//     flatMap { it.products }.
//     toSet().
//     filter { val product = it; customers.all { it.orders.flatMap { it.products }.any { it == product } } }.
//     toSet()
// }

fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
  val allProducts =  customers.
    flatMap { it.orders }.
    flatMap { it.products }.
    toSet()

  return customers.fold(allProducts, {
    orderedByAll, customer ->
      orderedByAll.intersect(customer.orders.flatMap { it.products }.toSet())
  })
}

////// Compound Tasks
// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? {
  return orders.
    filter { it.isDelivered }.
    flatMap { it.products }.
    maxBy { it.price }
}

// Return how many times the given product was ordered.
// Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
  return customers.
    flatMap { it.orders }.
    flatMap { it.products }.
    count { it == product }
}

////// Get used to new style



