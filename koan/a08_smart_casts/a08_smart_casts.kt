/*
// translate into kotling
public int eval(Expr expr) {
    if (expr instanceof Num) {
        return ((Num) expr).getValue();
    }
    if (expr instanceof Sum) {
        Sum sum = (Sum) expr;
        return eval(sum.getLeft()) + eval(sum.getRight());
    }
    throw new IllegalArgumentException("Unknown expression");
}

*/

fun eval(expr: Expr): Int  = evalwhen(expr)

fun evalif(expr: Expr): Int {
  if (expr is Num) return expr.value
  if (expr is Sum) return eval(expr.left) + eval(expr.right)
  throw IllegalArgumentException("Unknown expression")
}

fun evalwhen(expr: Expr): Int {
  return when(expr) {
    is Num -> expr.value
    is Sum -> eval(expr.left) + eval(expr.right)
    else -> throw IllegalArgumentException("Unknown expression")
  }
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun main(args: Array<String> = arrayOf()) {
  assert(eval(Num(1)) == 1)
  assert(eval(Sum(Num(1), Num(2))) == 3)
  println("OK")
}

