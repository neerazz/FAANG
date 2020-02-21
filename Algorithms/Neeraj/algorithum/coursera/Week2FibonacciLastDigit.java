import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

/*

Problem Description
Task: Given an integer n, find the last digit of the nth Fibonacci number F(n) (that is, F(n) mod 10).

Input Format: The input consists of a single integer n. Constraints: 0 ≤ n ≤ 10 ^7. Output Format: Output the last digit of F(n) .
Time Limits: C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript: 3 sec, Ruby: 3 sec, Scala: 3 sec.
Memory Limit: 512 Mb.

Sample 1
Input: 3 Output: 2
Sample 2
Input: 327305 Output: 5

 */
public class Week2FibonacciLastDigit {
    public static void main(String[] args) {
        FastScan scan = new FastScan();
        int fibonacciNumber = scan.nextInt();
        int[] nFibonacciNumber = getNFibonacciNumber(fibonacciNumber + 1);
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(getLastDigit(nFibonacciNumber[fibonacciNumber]));
        System.out.println("Time took to complete is:" + ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()));
    }

    static int[] getNFibonacciNumber(int fibonacciNumber) {
        int[] numberArray = new int[fibonacciNumber];
        for (int i = 0; i < fibonacciNumber; i++) {
            if (i == 0) numberArray[i] = 0;
            else if (i == 1) numberArray[i] = 1;
            else numberArray[i] = getLastDigit(numberArray[i - 1] + (numberArray[i - 2]));
        }
        return numberArray;
    }

    static int getLastDigit(int number) {
        String value = String.valueOf(number);
        return Integer.parseInt(String.valueOf(value.charAt(value.length() - 1)));
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        FastScan() {
            try {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FastScan(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
