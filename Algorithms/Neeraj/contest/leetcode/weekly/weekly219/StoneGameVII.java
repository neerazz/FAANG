package weekly.weekly219;

/**
 * Created on:  Dec 12, 2020
 * Questions:
 */

public class StoneGameVII {

    public static void main(String[] args) {
        System.out.println(stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        System.out.println(stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
        System.out.println(stoneGameVII(new int[]{792, 195, 697, 271, 743, 51, 836, 322, 135, 550, 399, 182, 988, 25, 395, 254, 480, 931, 513, 772, 798, 102, 110, 915, 794, 330, 597, 220, 789, 462}));
    }

    public static int stoneGameVII(int[] stones) {
        int len = stones.length, sum = 0;
        Integer[][] dp = new Integer[len][len];
        for (int stone : stones) sum += stone;
        int max = helper(stones, 0, len - 1, sum, dp, 0);
        return max;
    }

    private static int helper(int[] stones, int start, int end, int sum, Integer[][] dp, int player) {
        if (start == end) return dp[start][end] = 0;
        if (dp[start][end] != null) return dp[start][end];
        int first = helper(stones, start + 1, end, sum - stones[start], dp, player ^ 1);
        int last = helper(stones, start, end - 1, sum - stones[end], dp, player ^ 1);
        return dp[start][end] = Math.max(sum - stones[start] - first, sum - stones[end] - last);
    }
}
