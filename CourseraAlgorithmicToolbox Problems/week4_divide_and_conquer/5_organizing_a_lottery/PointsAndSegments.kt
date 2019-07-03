import java.util.*

fun fastCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
    //write your code here
    return IntArray(points.size)
}

fun naiveCountSegments(starts: IntArray, ends: IntArray, points: IntArray): IntArray {
    val cnt = IntArray(points.size)
    for (i in points.indices) {
        for (j in starts.indices) {
            if (starts[j] <= points[i] && points[i] <= ends[j]) {
                cnt[i]++
            }
        }
    }
    return cnt
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n: Int
    val m: Int
    n = scanner.nextInt()
    m = scanner.nextInt()
    val starts = IntArray(n)
    val ends = IntArray(n)
    val points = IntArray(m)
    for (i in 0 until n) {
        starts[i] = scanner.nextInt()
        ends[i] = scanner.nextInt()
    }
    for (i in 0 until m) {
        points[i] = scanner.nextInt()
    }
    //use fastCountSegments
    val cnt = naiveCountSegments(starts, ends, points)
    for (x in cnt) {
        print(x.toString() + " ")
    }
}