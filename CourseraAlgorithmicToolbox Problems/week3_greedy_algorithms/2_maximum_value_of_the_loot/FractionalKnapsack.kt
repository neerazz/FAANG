import java.util.*

fun getOptimalValue(capacity: Int, values: IntArray, weights: IntArray): Double {
    //write your code here
    return 0.0
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val capacity = scanner.nextInt()
    val values = IntArray(n)
    val weights = IntArray(n)
    for (i in 0 until n) {
        values[i] = scanner.nextInt()
        weights[i] = scanner.nextInt()
    }
    println(getOptimalValue(capacity, values, weights))
}