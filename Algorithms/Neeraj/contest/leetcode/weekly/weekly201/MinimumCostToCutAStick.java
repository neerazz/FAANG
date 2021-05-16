package weekly.weekly201;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 */
public class MinimumCostToCutAStick {
    static int minCost;

    public static void main(String[] args) {
        System.out.println("*************************** Greedy *******************************");
        System.out.println(minCost_Greedy(7, new int[]{1, 3, 4, 5}) + " 16");
        System.out.println(minCost_Greedy(9, new int[]{5, 6, 1, 4, 2}) + " 22");
        System.out.println(minCost_Greedy(30, new int[]{18, 15, 13, 7, 5, 26, 25, 29}) + " 92");

        System.out.println("*************************** DP *******************************");
        System.out.println(minCost_DP(7, new int[]{1, 3, 4, 5}) + " 16");
        System.out.println(minCost_DP(9, new int[]{5, 6, 1, 4, 2}) + " 22");
        System.out.println(minCost_DP(30, new int[]{18, 15, 13, 7, 5, 26, 25, 29}) + " 92");
    }

    public static int minCost_DP(int n, int[] cuts) {
//        Try cutting in all the possible places.
        Arrays.sort(cuts);
        int[] temp = new int[cuts.length + 2];
        int i = 1;
        for (int cut : cuts) {
            temp[i++] = cut;
        }
        temp[cuts.length + 1] = n;
        cuts = temp;
        Integer[][] dp = new Integer[cuts.length + 1][cuts.length + 1];
        return getCutValue(0, cuts.length - 1, cuts, dp);
    }

    private static int getCutValue(int start, int end, int[] cuts, Integer[][] dp) {
        if (start + 1 == end) return 0;
        if (dp[start][end] != null) return dp[start][end];
//        To cut wood with a start and end. Try cutting at all possible values and get the min.
        dp[start][end] = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            int next = cuts[end] - cuts[start] + getCutValue(start, i, cuts, dp) + getCutValue(i, end, cuts, dp);
            dp[start][end] = Math.min(dp[start][end], next);
        }
        return dp[start][end];
    }

    public static int minCost_Greedy(int n, int[] cuts) {
        minCost = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int cut : cuts) {
            set.add(cut);
        }
        performCut(0, n, set);
        return minCost;
    }

    private static void performCut(int start, int end, TreeSet<Integer> cuts) {
        if (start + 1 == end) return;
        minCost += end - start;
        int mid = start + (end - start) / 2, currentSelectedCut = 0;
        Integer floor = cuts.floor(mid), ceiling = cuts.ceiling(mid);
//        Chose the closest closest currentSelectedCut to mid and currentSelectedCut at that point.
        if (floor == null) {
            currentSelectedCut = ceiling;
        } else if (ceiling == null) {
            currentSelectedCut = floor;
        } else {
            currentSelectedCut = mid - floor < ceiling - mid ? floor : ceiling;
        }
//        Remove the selected cut
        cuts.remove(currentSelectedCut);
//        Cut left side block if there is a cut between start and currentSelectedCut;
        if (cuts.floor(currentSelectedCut) != null && cuts.floor(currentSelectedCut) > start) {
            performCut(start, currentSelectedCut, cuts);
        }
//        Cut right side block if there is a cut between currentSelectedCut and end;
        if (cuts.ceiling(currentSelectedCut) != null && cuts.ceiling(currentSelectedCut) < end) {
            performCut(currentSelectedCut, end, cuts);
        }
    }
}
