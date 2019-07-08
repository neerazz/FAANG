import java.util.*

fun optimalPoints(segments: MutableList<Segment>): IntArray {
    //write your code here
    val points = IntArray(2 * segments.size)
    for (i in segments.indices) {
        points[2 * i] = segments[i].start
        points[2 * i + 1] = segments[i].end
    }
    return points
}

class Segment(var start: Int, var end: Int)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val segments = ArrayList<Segment>(n)
    repeat (n) {
        val start: Int = scanner.nextInt()
        val end: Int = scanner.nextInt()
        segments += Segment(start, end)
    }
    val points = optimalPoints(segments)
    println(points.size)
    for (point in points) {
        print(point.toString() + " ")
    }
}