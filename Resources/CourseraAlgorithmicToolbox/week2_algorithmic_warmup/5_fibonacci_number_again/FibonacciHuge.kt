import java.util.*

fun getFibonacciHugeNaive(n: Long, m: Long): Long {
    if (n <= 1) return n

    var previous: Long = 0
    var current: Long = 1

    for (i in 0 until n - 1) {
        val tmpPrevious = previous
        previous = current
        current += tmpPrevious
    }

    return current % m
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val m = scanner.nextLong()
    println(getFibonacciHugeNaive(n, m))
}