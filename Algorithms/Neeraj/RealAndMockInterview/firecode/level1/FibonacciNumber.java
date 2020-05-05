package firecode.level1;

import java.util.ArrayList;
import java.util.List;

/*
The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... The next number is found by adding up the two numbers before it.
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(0) + " should be 0");
        System.out.println(fib(1) + " should be 1");
        System.out.println(fib(3) + " should be 2");
        System.out.println(fib(5) + " should be 5");
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        for (int i = 2; i <= n + 1; i++) {
            integers.add(integers.get(i - 1) + integers.get(i - 2));
        }
        return integers.get(n);
    }
}
