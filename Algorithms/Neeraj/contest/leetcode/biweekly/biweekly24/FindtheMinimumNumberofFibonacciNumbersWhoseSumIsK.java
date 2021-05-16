package biweekly.biweekly24;
/*
    Created on:  Apr 18, 2020
 */

import java.util.*;

/**
 * Questions:
 */
public class FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(7));
        System.out.println(findMinFibonacciNumbers(10));
        System.out.println(findMinFibonacciNumbers(19));
        System.out.println(findMinFibonacciNumbers(3));
        System.out.println(findMinFibonacciNumbers(513314));
    }

    public static int findMinFibonacciNumbers(int k) {
        int pre1 = 1, pre2 = 1;
        int result = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(pre1);
        for (int i = 2; i <= k && pre1+pre2 <= k; i++) {
            int sum = pre1 + pre2;
            pre2 = pre1;
            pre1 = sum;
            set.add(sum);
        }
        return getNumbers(k, set, 0);
    }

    private static int getNumbers(int k, TreeSet<Integer> set, int count) {
        if (set.contains(k)) return ++count;
        int floor = set.floor(k);
        return getNumbers(k - floor, set, count + 1);
    }
}
