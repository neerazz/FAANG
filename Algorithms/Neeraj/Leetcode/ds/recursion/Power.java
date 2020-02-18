package ds.recursion;

/*
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
 */
public class Power {
    public static void main(String[] args) {
//        System.out.println(myPow(2.100000,3));
//        System.out.println(myPow(2.0,-2));
//        System.out.println(myPow(2.0,-10));
        System.out.println(Math.pow(0.00001, 2147483647));
        System.out.println(Math.pow(2, 2147483647));
        System.out.println(myPow(0.00001, 2147483647));
    }

    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE && x > 1) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/ x;
            n *= -1;
        }
        return n % 2 != 0 ? myPow(x * x, n / 2) * x : myPow(x * x, n / 2);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    private static double naive(double i, double x, int n) {
        if (n == 0) {
            return i;
        }
        i = i * x;
        n--;
        return naive(i, x, n);
    }
}
