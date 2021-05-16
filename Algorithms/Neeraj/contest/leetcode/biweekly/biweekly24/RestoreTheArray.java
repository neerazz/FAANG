package biweekly.biweekly24;
/*
    Created on:  Apr 18, 2020
 */

/**
 * Questions:
 */
public class RestoreTheArray {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArrays("1000", 10000) + " should be [1]");
        System.out.println(new Solution().numberOfArrays("1000", 10) + " should be [0]");
        System.out.println(new Solution().numberOfArrays("1317", 2000) + " should be [8]");
        System.out.println(new Solution().numberOfArrays("2020", 30) + " should be [1]");
        System.out.println(new Solution().numberOfArrays("1234567890", 90) + " should be [34]");
        System.out.println(new Solution().numberOfArrays("1111111111111", 1000000000) + " should be [4076]");
        System.out.println(new Solution().numberOfArrays("420513611027", 20) + " should be [2]");
        System.out.println(new Solution().numberOfArrays("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415", 823924906) + " should be [427125123]");
    }

    static class Solution {
        public int numberOfArrays(String s, int k) {
            Integer[] memo = new Integer[s.length()];
            return dfs(s, 0, k, memo);
        }

        private int dfs(String s, int i, int k, Integer[] memo) {
            if (s.length() == i) return 1;
            if (s.charAt(i) == '0') return 0;
            if (memo[i] != null) return memo[i];
            int result = 0;
            long cur = 0;
            for (int j = i; j < s.length(); j++) {
                cur = cur * 10 + s.charAt(j) - '0';
                if (cur > k) break;
                result += dfs(s, j + 1, k, memo);
                result %= 1_000_000_007;
            }
            return memo[i] = result;
        }
    }
}
