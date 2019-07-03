import java.util.*

fun gcdNaive(a: Int, b: Int): Int {
    var currentGcd = 1
    var d = 2
    while (d <= a && d <= b) {
        if (a % d == 0 && b % d == 0) {
            if (d > currentGcd) {
                currentGcd = d
            }
        }
        ++d
    }

    return currentGcd
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    println(gcdNaive(a, b))
}