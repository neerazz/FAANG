// by Guillaume Guy

object APlusB extends App {
  override def main(args: Array[String]): Unit = {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine()
    val result = (line.split(" ").map( x => BigInt(x)) take 2).sum
      System.out.print(result )

  }
}