import java.util.*

fun calcFib(n: Long): Long {
    return if (n <= 1) n else calcFib(n - 1) + calcFib(n - 2)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()

    println(calcFib(n))
}