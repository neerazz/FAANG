package weekly.weekly202;

import java.util.*;

/**
 * Created on:  Aug 15, 2020
 * Questions: https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 */
public class MinimumNumberOfDaysToEatNOranges {
    public static void main(String[] args) {
        System.out.println("********************************* Solution 1 *****************************");
        System.out.println(minDays(10) + " = 4");
        System.out.println(minDays(6) + " = 3");
        System.out.println(minDays(4) + " = 3");
        System.out.println(minDays(1) + " = 1");
        System.out.println(minDays(56) + " = 6");
        System.out.println("********************************* Solution 2 *****************************");
        System.out.println(minDays_optimal(10) + " = 4");
        System.out.println(minDays_optimal(6) + " = 3");
        System.out.println(minDays_optimal(4) + " = 3");
        System.out.println(minDays_optimal(1) + " = 1");
        System.out.println(minDays_optimal(56) + " = 6");
        System.out.println(minDays_optimal(84806671) + " = 32");
        System.out.println(minDays_optimal(993654) + " = 20");
        System.out.println(minDays_optimal(19786) + " = 15");
        System.out.println("********************************* Solution 3 *****************************");
        System.out.println(minDays_skipDP(10) + " = 4");
        System.out.println(minDays_skipDP(6) + " = 3");
        System.out.println(minDays_skipDP(4) + " = 3");
        System.out.println(minDays_skipDP(1) + " = 1");
        System.out.println(minDays_skipDP(56) + " = 6");
        System.out.println(minDays_skipDP(84806671) + " = 32");
        System.out.println(minDays_skipDP(993654) + " = 20");
        System.out.println(minDays_skipDP(19786) + " = 15");
    }

    public static int minDays_optimal(int n) {
//        Perform a BFS.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int days = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (poll == 0) return days;
                if (!visited.contains(poll - 1)) queue.add(poll - 1);
                if (poll % 2 == 0 && !visited.contains(poll / 2)) {
                    visited.add(poll / 2);
                    queue.add(poll / 2);
                }
                if (poll % 3 == 0 && !visited.contains(poll / 3)) {
                    visited.add(poll / 3);
                    queue.add(poll / 3);
                }
            }
            days++;
        }
        return days;
    }

    public static int minDays_skipDP(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 2);
        return recursion(n, map);
    }

    private static int recursion(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);
        int cur = n;
        if (n % 2 == 0) {
            cur = Math.min(cur, recursion(n / 2, map) + 1);
        } else {
            cur = Math.min(cur, recursion(n - 1, map) + 1);
        }
        if (n % 3 == 0) {
            cur = Math.min(cur, recursion(n / 3, map) + 1);
        } else if (n % 3 == 1) {
            cur = Math.min(cur, recursion(n - 1, map) + 1);
        } else if (n % 3 == 2) {
            cur = Math.min(cur, recursion(n - 2, map) + 2);
        }
        map.put(n, cur);
        return cur;
    }

    public static int minDays(int n) {
        if (n == 0) return 0;
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
//        When you have one or two orange you can finish it in 1 day.
        dp[1] = 1;
//        When 3 oranges, you can finish it in 2 days.
        dp[2] = dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[n];
    }
}
