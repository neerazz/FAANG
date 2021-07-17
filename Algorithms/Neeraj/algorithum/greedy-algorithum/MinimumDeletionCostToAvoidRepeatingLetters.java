import java.util.PriorityQueue;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */

public class MinimumDeletionCostToAvoidRepeatingLetters {

    public static void main(String[] args) {

    }

    public static int minCost_3(String s, int[] cost) {
        int totalCost = 0, len = s.length(), i = 0;
        while (i < len) {
            int j = i + 1;
            int curCost = cost[i], curMax = cost[i];
//            Advance and check of there are any repeated chars.
            while (j < len && s.charAt(i) == s.charAt(j)) {
//                Loop though all the k duplicate chars, and add the k-s smallest chars to teh totalCost cost.
                curCost += cost[j];
                curMax = Math.max(curMax, cost[j]);
                j++;
            }
            totalCost += curCost - curMax;
            i = j;
        }
        return totalCost;
    }

    public static int minCost_2(String s, int[] cost) {
        int totalCost = 0, len = s.length(), i = 0;
        while (i < len) {
            int j = i + 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(cost[i]);
//            Advance and check of there are any repeated chars.
            while (j < len && s.charAt(i) == s.charAt(j)) {
//                Loop though all the k duplicate chars, and add the k-s smallest chars to teh totalCost cost.
                pq.add(cost[j++]);
            }
            while (pq.size() > 1) {
                totalCost += pq.poll();
            }
            i = j;
        }
        return totalCost;
    }

    public static int minCost(String s, int[] cost) {
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
