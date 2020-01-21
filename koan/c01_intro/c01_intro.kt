// Introduction
// Implement an extension function Shop.getSetOfCustomers()
fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

// Filter Map
// Implement extension functions Shop.getCitiesCustomersAreFrom()
// and Shop.getCustomersFrom() using functions map and filter.

// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = customers.map { it.city }.toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter { it.city == city }


fun main(args: Array<String> = arrayOf()) {

  // Intro
  println(shop.getSetOfCustomers())

  // Filter Map
  println(shop.getCitiesCustomersAreFrom())
  println(shop.getCustomersFrom(Canberra))

  println("OK")
}

