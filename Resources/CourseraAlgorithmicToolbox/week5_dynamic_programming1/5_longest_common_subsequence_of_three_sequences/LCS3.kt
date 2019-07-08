import java.util.*
import kotlin.math.min

fun lcs3(a: IntArray, b: IntArray, c: IntArray): Int {
    //Write your code here
    return min(min(a.size, b.size), c.size)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val an = scanner.nextInt()
    val a = IntArray(an)
    for (i in 0 until an) {
        a[i] = scanner.nextInt()
    }
    val bn = scanner.nextInt()
    val b = IntArray(bn)
    for (i in 0 until bn) {
        b[i] = scanner.nextInt()
    }
    val cn = scanner.nextInt()
    val c = IntArray(cn)
    for (i in 0 until cn) {
        c[i] = scanner.nextInt()
    }
    println(lcs3(a, b, c))
}