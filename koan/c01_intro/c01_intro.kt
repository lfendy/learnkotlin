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





