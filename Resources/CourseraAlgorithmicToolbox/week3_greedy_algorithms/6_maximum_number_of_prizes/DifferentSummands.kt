import java.util.*

fun optimalSummands(n: Int): List<Int> {
    //write your code here
    return ArrayList()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val summands = optimalSummands(n)
    println(summands.size)
    for (summand in summands) {
        print(summand.toString() + " ")
    }
}