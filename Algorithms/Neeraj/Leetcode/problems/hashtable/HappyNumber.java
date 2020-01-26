package problems.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/
Write an algorithm to determine if a number is "happy".
A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
Example:
Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class HappyNumber {
    static HashSet<Integer> history = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(isHappy(19) + " should be [true].");
        System.out.println(isHappy(2) + " should be [false].");
        System.out.println(isHappy(4) + " should be [false].");
    }

    public static boolean isHappy(int n) {
        if (n == 1) return true;
        if (n < 4 || history.contains(n)) return false;
        return isHappy(squares(n));
    }

    private static int squares(int n) {
        int length = String.valueOf(n).length();
        if (length == 1) {
            return n * n;
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= length; i++) {
                int current = getNthDigit(n, i);
                list.add(current * current);
                history.add(current);
            }
            return list.stream().mapToInt(i -> i).sum();
        }
    }

    private static int getNthDigit(int n, int i) {
        return (int) ((n / (Math.pow(10, i - 1))) % 10);
    }
}
