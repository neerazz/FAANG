package weekly199;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/string-compression-ii/
 */
public class StringCompressionII {
    public static void main(String[] args) {
        System.out.println(getLengthOfOptimalCompression("aaabcccd", 2) + " = 4");
    }

    public static int getLengthOfOptimalCompression(String s, int k) {
        if (s.length() <= k) return 0;
        Integer[][] dp = new Integer[s.length() + 1][k + 1];
        return helper(s, 0, k, dp);
    }

    private static int helper(String s, int start, int del, Integer[][] dp) {
        int len = s.length();
//        If you reach a point were only k chars are present then return 0, means all teh char can be deleted so len will be zero.
        if (len - start == del) return 0;
        if (dp[len][del] != null) return dp[len][del];
//        Make a call by removing the cur char.
        int count1 = helper(s.substring(1), 0, del - 1, dp);
//        Make a call by not removing the cur char.
        int count2 = helper(s, 0, del, dp);
        return dp[len][del] = Math.min(count1, count2);
    }

    private static int compressString(String input) {
        char pre = ' ';
        int letters = 0, rep = 0, nums = 0;
        for (char cur : input.toCharArray()) {
            if (pre == cur) {
                rep++;
            } else {
                if (pre != ' ') letters++;
                if (rep > 1) nums++;
                rep = 1;
            }
            pre = cur;
        }
        letters++;
        if (rep > 1) nums++;
        return letters + nums;
    }
}
