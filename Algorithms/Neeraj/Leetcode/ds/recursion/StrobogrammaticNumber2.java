package ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem: A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.
Example:
Input:  n = 2
Output: ["11","69","88","96"]

Solution: https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.5.html
 */
public class StrobogrammaticNumber2 {
    public static void main(String[] args) {
        System.out.println(findStrobogrammatic(2));
        System.out.println(findStrobogrammatic(3));
        System.out.println(findStrobogrammatic(4));
        System.out.println(findStrobogrammatic(5));
    }

    public static List<String> findStrobogrammatic(int n) {
        return findStrobogrammaticValue(n, n);
    }

    public static List<String> findStrobogrammaticValue(int n, int total) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        List<String> result = new ArrayList<>();
        List<String> previous = findStrobogrammaticValue(n - 2, total);
        for (String s : previous) {
            if (n != total) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        Collections.sort(result);
        return result;
    }
}
