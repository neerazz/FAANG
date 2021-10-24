/**
 * Created on:  Jun 08, 2020
 * Questions: https://leetcode.com/problems/power-of-two/submissions/
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println("********************************* Method 1 ***********************************");
        System.out.println(isPowerOfTwo(1) + " should be [true]");
        System.out.println(isPowerOfTwo(2147483647) + " should be [false]");
        System.out.println(isPowerOfTwo(16) + " should be [true]");
        System.out.println(isPowerOfTwo(218) + " should be [false]");

        System.out.println("********************************* Method 2 ***********************************");
        System.out.println(isPowerOfTwo_optimal(1) + " should be [true]");
        System.out.println(isPowerOfTwo_optimal(2147483647) + " should be [false]");
        System.out.println(isPowerOfTwo_optimal(16) + " should be [true]");
        System.out.println(isPowerOfTwo_optimal(218) + " should be [false]");
    }

    public static boolean isPowerOfTwo_optimal(int n) {
        if (n == 1) return true;
        while (n > 0) {
            if (n == 2) return true;
            if (n % 2 == 1) return false;
            n >>= 1;
        }
        return false;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n % 2 == 1) return n == 1;
        int start = 0, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int midVal = (int) Math.pow(2, mid);
            if (midVal == n) return true;
            if (midVal > n) end = mid - 1;
            if (midVal < n) start = mid + 1;
        }
        return Math.pow(2, start) == n;
    }
}
