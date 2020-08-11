/**
 * Created on:  Aug 09, 2020
 * Questions: https://leetcode.com/problems/minimum-cost-to-merge-stones/
 */
public class MinimumCostToMergeStones {
    static int max = 999999;

    public static void main(String[] args) {

    }

    public static int mergeStones(int[] stones, int k) {
        int len = stones.length;
//        dp[a][b][c] = Cost of merging 'c' piles of stones from index 'a' to 'b'
        Integer[][][] dp = new Integer[len + 1][len + 1][k + 1];
        Integer result = helper(stones, 0, len - 1, k, k, dp);
        return result == null || result == max ? -1 : result;
    }

    private static Integer helper(int[] costs, int start, int end, int piles, int k, Integer[][][] dp) {
//        When your start and end are same and you have only one pile, the merge cost will be 0. Else it is not possible to merge.
        if (start == end) return piles == 1 ? 0 : max;
        if (dp[start][end][piles] != null) return dp[start][end][piles];
//        When you have many piles and you can merge only one pile, in that case teh cost of merge will be
        dp[start][end][piles] = max;
        if (piles == 1) {
            return dp[start][end][piles] = helper(costs, start, end, k, k, dp) + costs[end] - costs[start - 1];
        }
//        Loop through all the values from start to end and find the min value.
        for (int i = start; i < end; i++) {
//            F(start, end, piles) -> bestvalues to merge piles number of stones between start and end,
//              min( F(start, start+k, piles-1) + F(start+k+1, end, 1) )
            dp[start][end][piles] = Math.min(dp[start][end][piles], helper(costs, start, i, piles - 1, k, dp) + helper(costs, i + 1, end, 1, k, dp));
        }
        return dp[start][end][piles];
    }
}
