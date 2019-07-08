import java.util.*

fun optimalSequence(n: Int): List<Int> {
    var m = n
    val sequence = ArrayList<Int>()
    while (m >= 1) {
        sequence.add(m)
        when {
            m % 3 == 0 -> m /= 3
            m % 2 == 0 -> m /= 2
            else -> m -= 1
        }
    }
    return sequence.reversed()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val sequence = optimalSequence(n)
    println(sequence.size - 1)
    for (x in sequence) {
        print(x.toString() + " ")
    }
}