import java.util.*

fun optimalWeight(w: Int, array: IntArray): Int {
    //write you code here
    var result = 0
    for (i in array.indices) {
        if (result + array[i] <= w) {
            result += array[i]
        }
    }
    return result
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val w: Int
    val n: Int
    w = scanner.nextInt()
    n = scanner.nextInt()
    val array = IntArray(n)
    for (i in 0 until n) {
        array[i] = scanner.nextInt()
    }
    println(optimalWeight(w, array))
}