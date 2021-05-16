package weekly.weekly193;

import java.util.Arrays;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        System.out.println("************************************** Solution 1 ***********************************");
        System.out.println(minDays(new int[]{1000000000, 100000000}, 1, 1) + " should be [1000000000]");
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1) + " should be [3]");
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2) + " should be [-1]");
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3) + " should be [12]");
        System.out.println(minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5,}, 4, 2) + " should be [9]");

        System.out.println("************************************** Solution 2 ***********************************");
        System.out.println(minDays_optimal(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2) + " should be [9]");
        System.out.println(minDays_optimal(new int[]{1000000000, 100000000}, 1, 1) + " should be [1000000000]");
        System.out.println(minDays_optimal(new int[]{1, 10, 3, 10, 2}, 3, 1) + " should be [3]");
        System.out.println(minDays_optimal(new int[]{1, 10, 3, 10, 2}, 3, 2) + " should be [-1]");
        System.out.println(minDays_optimal(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3) + " should be [12]");

        System.out.println("************************************** Solution 3 ***********************************");
        System.out.println(minDays_rev1(new int[]{1, 10, 3, 10, 2}, 3, 1) + " should be [3]");
        System.out.println(minDays_rev1(new int[]{1, 10, 3, 10, 2}, 3, 2) + " should be [-1]");
        System.out.println(minDays_rev1(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2) + " should be [9]");
        System.out.println(minDays_rev1(new int[]{1000000000, 100000000}, 1, 1) + " should be [1000000000]");
        System.out.println(minDays_rev1(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3) + " should be [12]");
    }

    public static int minDays_rev1(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int min = 0, max = 0;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static boolean canMake(int[] days, int m, int k, int day) {
        int boq = 0, flow = 0;
        for (int d : days) {
            if (d > day) {
                flow = 0;
            } else {
                if (++flow == k) {
                    flow = 0;
                    boq++;
                }
            }
        }
        return boq >= m;
    }

    public static int minDays_optimal(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
//        Take the boundary starting from 1 to the max day in the bloomDay.
        while (min < max) {
            int mid = min + (max - min) / 2;
            int possibleBookies = getPossibleBookies(bloomDay, mid, k);
//            The
            if (possibleBookies < m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private static int getPossibleBookies(int[] bloomDay, int day, int k) {
//        This method is to find the number of bouquets that can be formed on a given day.
        int bouquets = 0, flowersCollected = 0;
        for (int value : bloomDay) {
            if (value <= day) {
//                If the current flower can be taken with in days then increase the flower flowersCollected.
                flowersCollected++;
            } else {
//                If there is a flower in between that takes more number of days then the given day, then resent the counter.
                flowersCollected = 0;
            }
//            If the flowersCollected is same as the required flower per bookie, then increase the bouquets count;
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int len = bloomDay.length;
        int[][] dp = new int[2][len + 1];
        Arrays.fill(dp[1], Integer.MAX_VALUE);
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= len; col++) {
                if (col >= row * k) {
                    int preMax = dp[0][col - k];
                    for (int inner = col - k; inner < col; inner++) {
                        preMax = Math.max(preMax, bloomDay[inner]);
                    }
                    dp[1][col] = Math.min(preMax, dp[1][col - 1]);
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, len + 1);
            Arrays.fill(dp[1], Integer.MAX_VALUE);
        }
        return dp[0][len];
    }
}
