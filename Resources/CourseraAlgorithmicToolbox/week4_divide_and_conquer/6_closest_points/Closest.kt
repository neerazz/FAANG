import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.*

var tok = StringTokenizer("")

class Point(var x: Long, var y: Long) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        return if (other.y == y) java.lang.Long.signum(x - other.x)
        else java.lang.Long.signum(y - other.y)
    }
}

fun minimalDistance(x: IntArray, y: IntArray): Double {
    //write your code here
    return java.lang.Double.POSITIVE_INFINITY
}

fun main(args: Array<String>) {
    val writer = PrintWriter(System.out)
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = nextInt(reader)
    val x = IntArray(n)
    val y = IntArray(n)
    for (i in 0 until n) {
        x[i] = nextInt(reader)
        y[i] = nextInt(reader)
    }
    println(minimalDistance(x, y))
    writer.close()
}


fun next(reader: BufferedReader): String? {
    while (!tok.hasMoreTokens()) {
        var w: String? = null
        try {
            w = reader.readLine()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (w == null)
            return null
        tok = StringTokenizer(w)
    }
    return tok.nextToken()
}

fun nextInt(reader: BufferedReader): Int {
    return next(reader)!!.toInt()
}