import java.util.*;

public class W2_FibonacciPartialSum {

    //Given two non-negative integers 𝑚 and 𝑛, where 𝑚 ≤ 𝑛, find the last digit of the sum 𝐹𝑚 + 𝐹𝑚+1 + ···+𝐹𝑛.

    private static long getFibonacciPartialSumFast(long from, long to) {
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }


    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;
        long current = 0;
        long next = 1;
        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }
            long new_current = next;
            next = next + current;
            current = new_current;
        }
        return sum % 10;
    }
}