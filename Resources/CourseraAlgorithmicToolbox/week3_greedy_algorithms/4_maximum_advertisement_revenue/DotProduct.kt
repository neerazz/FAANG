import java.util.*

fun maxDotProduct(a: IntArray, b: IntArray): Long {
    //write your code here
    var result: Long = 0
    for (i in a.indices) {
        result += (a[i] * b[i]).toLong()
    }
    return result
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val b = IntArray(n)
    for (i in 0 until n) {
        b[i] = scanner.nextInt()
    }
    println(maxDotProduct(a, b))
}