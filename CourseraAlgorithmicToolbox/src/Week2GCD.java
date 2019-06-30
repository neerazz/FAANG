/*

3 Greatest Common Divisor
Problem Introduction
The greatest common divisor GCD(𝑎, 𝑏) of two non-negative integers 𝑎 and 𝑏
(which are not both equal to 0) is the greatest integer 𝑑 that divides both 𝑎 and 𝑏.
Your goal in this problem is to implement the Euclidean algorithm for computing
the greatest common divisor.
Efficient algorithm for computing the greatest common divisor is an important
basic primitive of commonly used cryptographic algorithms like RSA.
GCD(1344, 217)
= GCD(217, 42)
= GCD(42, 7)
= GCD(7, 0)
=7
Problem Description
Task. Given two integers 𝑎 and 𝑏, find their greatest common divisor.
Input Format. The two integers 𝑎, 𝑏 are given in the same line separated by space.
Constraints. 1 ≤ 𝑎, 𝑏 ≤ 2 · 109
.
Output Format. Output GCD(𝑎, 𝑏).
Sample 1.
Input:
18 35
Output:
1
18 and 35 do not have common non-trivial divisors.
Sample 2.
Input:
28851538 1183019
Output:
17657
28851538 = 17657 · 1634, 1183019 = 17657 · 67.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Week2GCD {

    public static void main(String[] args) {
        long fistNumber = FastScan.nextLong();
        long secondNumber = FastScan.nextLong();
        System.out.println(findGCD(fistNumber, secondNumber));
    }

    private static long findGCD(long fistNumber, long secondNumber) {
        if (secondNumber == 0) return fistNumber;
        else {
            long remainder = fistNumber % secondNumber;
            return findGCD(secondNumber, remainder);
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
    }
}
