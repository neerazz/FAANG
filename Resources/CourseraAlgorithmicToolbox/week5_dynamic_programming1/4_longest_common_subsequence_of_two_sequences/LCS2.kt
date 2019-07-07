import java.util.*
import kotlin.math.min

fun lcs2(a: IntArray, b: IntArray): Int {
    //Write your code here
    return min(a.size, b.size)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()
    val b = IntArray(m)
    for (i in 0 until m) {
        b[i] = scanner.nextInt()
    }

    println(lcs2(a, b))
}