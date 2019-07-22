import java.util.*

fun getNumberOfInversions(a: IntArray, b: IntArray, left: Int, right: Int): Long {
    var numberOfInversions: Long = 0
    if (right <= left + 1) {
        return numberOfInversions
    }
    val ave = (left + right) / 2
    numberOfInversions += getNumberOfInversions(a, b, left, ave)
    numberOfInversions += getNumberOfInversions(a, b, ave, right)
    //write your code here
    return numberOfInversions
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = scanner.nextInt()
    }
    val b = IntArray(n)
    println(getNumberOfInversions(a, b, 0, a.size))
}