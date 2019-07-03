import java.util.*

fun partition3(array: IntArray): Int {
    //write your code here
    return 0
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val array = IntArray(n)
    for (i in 0 until n) {
        array[i] = scanner.nextInt()
    }
    println(partition3(array))
}