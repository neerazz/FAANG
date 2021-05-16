package weekly.weekly205;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 */
public class MinimumDeletionCostToAvoidRepeatingLetters {
    public static void main(String[] args) {

    }

    public int minCost(String s, int[] cost) {
        int totalCost = 0, len = s.length();
        char pre = ' ';
        int preCost = 0;
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (pre == cur) {
                totalCost += Math.min(preCost, cost[i]);
                preCost = Math.max(preCost, cost[i]);
            } else {
                preCost = cost[i];
            }
            pre = cur;
        }
        return totalCost;
    }
}
