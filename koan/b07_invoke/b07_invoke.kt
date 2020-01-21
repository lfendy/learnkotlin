class Invokable {
  var numberOfInvocations: Int = 0
  private set
  operator fun invoke(): Invokable {
    numberOfInvocations++
    return this
  }
}

fun invokeTwice(invokable: Invokable) = invokable()()

fun main(args: Array<String> = arrayOf()) {
  assert(invokeTwice(Invokable()).numberOfInvocations == 2)
  println("OK")
}

