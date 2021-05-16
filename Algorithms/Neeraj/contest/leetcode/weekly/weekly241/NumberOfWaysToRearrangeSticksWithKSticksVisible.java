package weekly.weekly241;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-241/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/
 */

public class NumberOfWaysToRearrangeSticksWithKSticksVisible {

    //    https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/discuss/1211071/Java-dfs-%2B-memo
//    https://leetcode.com/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/discuss/1211068/Java-DP-time%3A-O(n-*-k)-with-detailed-explanation
    static long result, mod = 1_000_000_007;

    public static void main(String[] args) {

    }

    public static int rearrangeSticks(int n, int k) {
        return (int) (result % mod);
    }
}
