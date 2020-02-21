package ds.binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.
Example 1:
Input: 16
Output: true
Example 2:
Input: 14
Output: false
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println("Answer is:" + isPerfectSquare(16) + " should be [true].");
        System.out.println("Answer is:" + isPerfectSquare(14) + " should be [false].");
        System.out.println("Answer is:" + isPerfectSquare(9) + " should be [true].");
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
