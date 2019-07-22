import java.util.*

fun getMaximValue(exp: String): Long {
    //write your code here
    return 0
}

fun eval(a: Long, b: Long, op: Char): Long = when (op) {
    '+' -> a + b
    '-' -> a - b
    '*' -> a * b
    else -> {
        assert(false)
        0
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val exp = scanner.next()
    println(getMaximValue(exp))
}