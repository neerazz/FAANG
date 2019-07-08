import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun binarySearch(a: IntArray, x: Int): Int {
    val left = 0
    val right = a.size
    //write your code here

    return -1
}

fun linearSearch(a: IntArray, x: Int): Int {
    for (i in a.indices) {
        if (a[i] == x) return i
    }
    return -1
}

fun main(args: Array<String>) {
    val scanner = FastScanner(System.`in`)
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
    for (i in 0 until m) {
        //replace with the call to binarySearch when implemented
        print(linearSearch(a, b[i]).toString() + " ")
    }
}

class FastScanner(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}