import java.util.*

fun largestNumber(a: MutableList<String>): String {
    //write your code here
    return a.joinToString("")
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = ArrayList<String>(n)
    repeat(n) {
        a += scanner.next()
    }
    println(largestNumber(a))
}