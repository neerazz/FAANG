/**
 * Created on:  Aug 29, 2020
 * Questions: https://www.algoexpert.io/questions/Palindrome%20Partitioning%20Min%20Cuts
 */
public class PalindromePartitioningMinCuts {
    public static void main(String[] args) {
        System.out.println(palindromePartitioningMinCuts("noonabbad"));
    }

    public static int palindromePartitioningMinCuts(String str) {
        if (str == null || str.length() == 1) return 0;
        int start = 0, end = str.length() - 1;
        Integer[][] dp = new Integer[end + 2][end + 2];
        return helper(str.toCharArray(), start, end, dp);
    }

    private static int helper(char[] chars, int start, int end, Integer[][] dp) {
        if (start == end) return 0;
        if (dp[start][end] != null) return dp[start][end];
        int cuts = Integer.MAX_VALUE;
        String sb1 = "", sb2 = "";
        for (int i = start; i <= end; i++) {
            sb1 += chars[i];
            sb2 = chars[i] + sb2;
            if (sb1.equals(sb2)) {
                int next = helper(chars, i + 1, end, dp);
                if (next != Integer.MAX_VALUE) {
                    cuts = Math.min(cuts, next + 1);
                }
            }
        }
        if (sb1.equals(sb2)) {
            cuts = 0;
        }
        return dp[start][end] = cuts;
    }
}
