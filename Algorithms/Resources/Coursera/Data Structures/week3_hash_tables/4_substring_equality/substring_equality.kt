class Solver(private val s: String) {
    init {
    }
    fun ask(a: Int, b: Int, l: Int) = s.substring(a, a + l) == s.substring(b, b + l)
}

fun main(args: Array<String>) {
    val inp = System.`in`.bufferedReader()
    val out = System.`out`.bufferedWriter()
    val s = inp.readLine()!!
    val q = inp.readLine()!!.toInt()
    val solver = Solver(s);
    for (i in 0 until q) {
        val (a, b, l) = inp.readLine()!!.split(" ").map {it.toInt()}
        out.write(if (solver.ask(a, b, l)) "Yes\n" else "No\n")
    }
    out.close()
}
