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
//        When you have many piles and you can merge only one pile, in that case teh cost of merge will be
        if (piles == 1) {

        }
        return null;
    }
}
