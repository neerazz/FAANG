import java.util.*

fun lcmNaive(a: Int, b: Int): Long {
    for (l in 1..a.toLong() * b)
        if (l % a == 0L && l % b == 0L)
            return l

    return a.toLong() * b
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(lcmNaive(a, b))
}