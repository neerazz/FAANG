package ds.binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/
Implement pow(x, n), which calculates x raised to the power n (xn).
Example 1:
Input: 2.00000, 10
Output: 1024.00000
Example 2:
Input: 2.10000, 3
Output: 9.26100
Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:
-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println("Answer is:" + myPow(2.00000, 10) + " should be [1024.00000].");
        System.out.println("Answer is:" + myPow(2.10000, 3) + " should be [9.26100].");
        System.out.println("Answer is:" + myPow(2.00000, -2) + " should be [0.25000].");
        System.out.println("Answer is:" + myPow(2.00000, -2147483648) + " should be [0.0].");
        System.out.println("Answer is:" + myPow_elegent(-1.00000, 2147483647) + " should be [-1.0].");
        System.out.println("Answer is:" + myPow_elegent(-1.00000, -2147483648) + " should be [1.0].");
    }

    public static double myPow_elegent(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double half = myPow_elegent(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                if (n > 0) {
                    return half * half * x;
                } else {
                    return half * half / x;
                }
            }
        }
    }

    public static double myPow(double x, int n) {
        if (x == 1 || x == -1) return x;
        if (n == Integer.MAX_VALUE || n == Integer.MIN_VALUE) return 0;
        if (n < 0) return 1 / helper(x, Math.abs(n));
        return helper(x, Math.abs(n));
    }

    private static double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double res = myPow(x, n / 2);
        return res * res * (n % 2 == 0 ? 1 : x);
    }
}
