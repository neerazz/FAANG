import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
Problem Description
Task. Given two integers 𝑛 and 𝑚, output 𝐹𝑛 mod 𝑚 (that is, the remainder of 𝐹𝑛 when divided by 𝑚).
Input Format. The input consists of two integers 𝑛 and 𝑚 given on the same line (separated by a space).
Constraints. 1 ≤ 𝑛 ≤ 1014
, 2 ≤ 𝑚 ≤ 103
.
Output Format. Output 𝐹𝑛 mod 𝑚.
Sample 1.
Input:
239 1000
Output:
161
𝐹239 mod 1 000 = 39 679 027 332 006 820 581 608 740 953 902 289 877 834 488 152 161 (mod 1 000) = 161.
Sample 2.
Input:
2816213588 239
Output:
151
𝐹2 816 213 588 does not fit into one page of this file, but 𝐹2 816 213 588 mod 239 = 151.

Refer: https://medium.com/competitive/huge-fibonacci-number-modulo-m-6b4926a5c836
 */
public class Week2FibonacciMod {

    public static void main(String[] args) {
        BigInteger fistNumber = FastScan.nextBigInteger();
        long secondNumber = FastScan.nextLong();
        if (fistNumber.compareTo(BigInteger.valueOf(secondNumber)) > 0) {
            long periodicRemainder = getPeriodicRemainder(BigInteger.valueOf(secondNumber));
//            System.out.println("periodicRemainder:" + periodicRemainder);
            long remainder = fistNumber.remainder(BigInteger.valueOf(periodicRemainder)).longValue();
            System.out.println(getModValue(remainder, secondNumber));
        } else {
            System.out.println(getModValue(fistNumber.longValue(), secondNumber));
        }
    }

    private static BigInteger getModValue(long remainder, long secondNumber) {
        BigInteger mod = getNthFibonacciNumber(remainder).remainder(BigInteger.valueOf(secondNumber));
//        System.out.println("mod:" + mod);
        return mod;
    }

    private static BigInteger getNthFibonacciNumber(long fibonacciNumber) {
        BigInteger last = BigInteger.ZERO;
        BigInteger lastBefore = BigInteger.ZERO;
        BigInteger fibonacci = last.add(lastBefore);

        for (long i = 0; i <= fibonacciNumber; i++) {
            if (i == 1) {
                last = BigInteger.ONE;
                lastBefore = BigInteger.ZERO;
            }
            fibonacci = lastBefore.add(last);
            last = lastBefore;
            lastBefore = fibonacci;
        }
//        System.out.println("fibonacci of " + fibonacciNumber + " is:" + fibonacci);
        return fibonacci;
    }

    private static long getPeriodicRemainder(BigInteger secondNumber) {
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger period = first.add(second);

        long counter = 0;

        while (true) {
            period = first.add(second).remainder(secondNumber);
            first = second;
            second = period;
            if (first.toString().equals("0") && second.toString().equals("1")) return counter + 1;
            counter++;
        }
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static BigInteger nextBigInteger() {
            return BigInteger.valueOf(nextLong());
        }
    }
}
