/*
    Created on:  May 09, 2020
 */

/**
 * Questions:
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
        System.out.println(isPerfectSquare(14));
        System.out.println("******************************");
        System.out.println(isPerfectSquare_elegant(2147483647) + " should be [false]");
        System.out.println(isPerfectSquare_elegant(14) + " should be [false]");
        System.out.println(isPerfectSquare_elegant(9) + " should be [true]");
        System.out.println(isPerfectSquare_elegant(16) + " should be [true]");
        System.out.println(isPerfectSquare_elegant(808201) + " should be [true]");
    }

    public static boolean isPerfectSquare_elegant(int num) {
        long start = 0, end = num;
        while (start < end) {
            long mid = start + (end - start) / 2;
            long temp = mid * mid;
            if (temp == num)
                return true;
            if (temp < num)
                start = mid + 1;
            else end = mid;
        }
        return start == end && start * end == num;
    }

    public static boolean isPerfectSquare(int num) {
        int temp = 1;
        while (temp * temp <= num) {
            if (temp * temp == num)
                return true;
            temp++;
        }
        return false;
    }
}
