import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 25, 2020
 * Questions: https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTickets {
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}) + " = 11");
    }

    public static int mincostTickets(int[] days, int[] costs) {
        Integer[] dp = new Integer[366];
        Set<Integer> set = new HashSet<>();
        for (int day : days) set.add(day);
        return getCost(1, set, dp, costs);
    }

    private static int getCost(int day, Set<Integer> days, Integer[] dp, int[] costs) {
        if (day > 365) return 0;
        if (dp[day] != null) return dp[day];
        int cur = Integer.MAX_VALUE;
//        If you have to travel on this day then the current days cost will be: min cost of travelling
        if (days.contains(day)) {
            cur = Math.min(getCost(day + 1, days, dp, costs) + costs[0], getCost(day + 7, days, dp, costs) + costs[1]);
            cur = Math.min(cur, getCost(day + 30, days, dp, costs) + costs[2]);
        } else {
//            If you do have to travel on current day then cost of current day will be same as cost of next day.
            cur = getCost(day + 1, days, dp, costs);
        }
        return dp[day] = cur;
    }
}
