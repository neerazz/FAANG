import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*

Problem Description
Task. Given two non-negative integers 𝑚 and 𝑛, where 𝑚 ≤ 𝑛, find the last digit of the sum 𝐹𝑚 + 𝐹𝑚+1 +
· · · + 𝐹𝑛.
Input Format. The input consists of two non-negative integers 𝑚 and 𝑛 separated by a space.
Constraints. 0 ≤ 𝑚 ≤ 𝑛 ≤ 1014
.
Output Format. Output the last digit of 𝐹𝑚 + 𝐹𝑚+1 + · · · + 𝐹𝑛.
Sample 1.
Input:
3 7
Output:
1
𝐹3 + 𝐹4 + 𝐹5 + 𝐹6 + 𝐹7 = 2 + 3 + 5 + 8 + 13 = 31.
Sample 2.
Input:
10 10
Output:
5
𝐹10 = 55.
Sample 3.
Input:
10 200
Output:
2
𝐹10 + 𝐹11 + · · · + 𝐹200 = 734 544 867 157 818 093 234 908 902 110 449 296 423 262
 */
public class Week2FibonacciLastDigitOfSumAgain {
    public static void main(String[] args) {
        FastScan scan = new FastScan();
        int fibonacciNumber = scan.nextInt();
        BigInteger[] nFibonacciNumber = getNFibonacciNumber(fibonacciNumber + 1);
        String valueOf = String.valueOf(sumOfArray(nFibonacciNumber));
        System.out.println(valueOf.charAt(valueOf.length() - 1));
    }

    private static BigInteger sumOfArray(BigInteger[] nFibonacciNumber) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < nFibonacciNumber.length; i++) {
            result = result.add(nFibonacciNumber[i]);
        }
        return result;
    }

    private static BigInteger[] getNFibonacciNumber(int fibonacciNumber) {
        BigInteger[] numberArray = new BigInteger[fibonacciNumber];
        for (int i = 0; i < fibonacciNumber; i++) {
            if (i == 0) numberArray[i] = BigInteger.valueOf(0);
            else if (i == 1) numberArray[i] = BigInteger.valueOf(1);
            else numberArray[i] = numberArray[i - 1].add(numberArray[i - 2]);
        }
        return numberArray;
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
    }
}
