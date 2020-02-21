package ds.arraysAndString;

/*
https://leetcode.com/problems/ugly-number/
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
Example 1:
Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:
Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:
Input: 14
Output: false
Explanation: 14 is not ugly since it includes another prime factor 7.
 */
public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(6) + " should [true].");
        System.out.println(isUgly(8) + " should [true].");
        System.out.println(isUgly(14) + " should [false].");
    }

    public static boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        boolean ugly = false;
        if (num % 2 == 0)
            ugly = ugly || isUgly(num / 2);
        if (num % 3 == 0)
            ugly = ugly || isUgly(num / 3);
        if (num % 5 == 0)
            ugly = ugly || isUgly(num / 5);
        return ugly;
    }
}
