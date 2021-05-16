package biweekly.biweekly28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jun 13, 2020
 * Questions:
 */
public class AllocateMailboxes {
    static Map<String, Integer> memo;

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 *****************************");
        System.out.println(minDistance(new int[]{1, 4, 8, 10, 20}, 3) + " should be [5]");
        System.out.println(minDistance(new int[]{14, 2, 5, 7, 10}, 2) + " should be [9]");
        System.out.println(minDistance(new int[]{15, 8, 9, 6}, 1) + " should be [10]");
        System.out.println("****************************** Solution 2 *****************************");
        System.out.println(minDistance_rev1(new int[]{1, 4, 8, 10, 20}, 3) + " should be [5]");
        System.out.println(minDistance_rev1(new int[]{14, 2, 5, 7, 10}, 2) + " should be [9]");
        System.out.println(minDistance_rev1(new int[]{15, 8, 9, 6}, 1) + " should be [10]");
    }

    public static int minDistance_rev1(int[] houses, int k) {
        int len = houses.length;
        Arrays.sort(houses);
        Integer[][] dp = new Integer[len+1][k+1];
        return helper(houses, k,dp,0);
    }
    private static int helper(int[] houses, int rem, Integer[][] dp, int start){
        if(rem == 0) return start == houses.length ? 0 : Integer.MAX_VALUE;
        if(rem < 0 || start > houses.length) return Integer.MAX_VALUE;
        if(dp[start][rem] != null) return dp[start][rem];
        int min = Integer.MAX_VALUE;
        for(int end = start; end<houses.length; end++){
            int next = helper(houses,rem-1,dp,end+1);
            if(next != Integer.MAX_VALUE){
                int dist = getDistance(houses, start, end);
                min = Math.min(min, dist+next);
            }
        }
        return dp[start][rem] = min;
    }

    public static int minDistance(int[] houses, int k) {
        memo = new HashMap<>();
        Arrays.sort(houses);
        return backTracking(houses, 0, k, 0);
    }

    private static int backTracking(int[] houses, int start, int k, int boxes) {
        if (boxes == k) return start >= houses.length ? 0 : Integer.MAX_VALUE;
        if (boxes > k || start >= houses.length) return Integer.MAX_VALUE;
        String key = start + "-" + boxes;
        if (memo.containsKey(key)) return memo.get(key);
        int val = Integer.MAX_VALUE;
        for (int end = start; end < houses.length; end++) {
            int dist = getDistance(houses, start, end);
            int next = backTracking(houses, end + 1, k, boxes + 1);
            if (next != Integer.MAX_VALUE) {
                val = Math.min(dist + next, val);
            }
        }
        memo.put(key, val);
        return val;
    }

    private static int getDistance(int[] houses, int start, int end) {
        if(start == end) return 0;
        int dist = 0, mid = start + (end-start)/2;
        while(start <= end){
            dist += Math.abs(houses[start++] - houses[mid]);
        }
        return dist;
    }
}
