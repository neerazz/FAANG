package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

Problem Description
Task. Given two integers 𝑎 and 𝑏, find their least common multiple.

Input Format. The two integers 𝑎 and 𝑏 are given in the same line separated by space. Constraints. 1 ≤ 𝑎, 𝑏 ≤ 107.
Output Format. Output the least common multiple of 𝑎 and 𝑏.

Sample 1.
Input:
6 8
Output:
24
Among all the positive integers that are divisible by both 6 and 8 (e.g., 48, 480, 24), 24 is the smallest
one.
Sample 2.
Input:
761457 614573
Output:
467970912861

 */
public class Week2LCM {

    public static void main(String[] args) {
        long fistLong = FastScan.nextLong();
        long secondLong = FastScan.nextLong();
        System.out.println(findLCM(fistLong, secondLong));
    }

    private static long findLCM(long fistLong, long secondLong) {
        return (fistLong * secondLong) / findGCD(fistLong, secondLong);
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
