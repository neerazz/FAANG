package biweekly.biweekly34;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/number-of-ways-to-split-a-string/
 */
public class NumberOfWaysToSplitAString {
    public static void main(String[] args) {
        System.out.println(numWays("10101") + " = 4");
        System.out.println(numWays("1001") + " = 0");
        System.out.println(numWays("0000") + " = 3");
        System.out.println(numWays("100100010100110") + " = 12");
    }

    public static int numWays(String s) {
        int mod = 1_000_000_007;
        int ones = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') ones++;
        }
//        If all the numbers are zero.
        if (ones == 0) {
            long n = len - 1;
            return (int) ((n * (n - 1) / 2) % mod);
        }
        if (ones % 3 != 0) return 0;
        long each = ones / 3, left = 0, right = 0, sum = 0;
//        In there are ones in between.
        for (int i = 0; i < len; i++) {
            sum += s.charAt(i) == '1' ? 1 : 0;
            if (sum == each) left++;
            if (sum == 2 * each) right++;
        }
        return (int) ((left * right) % mod);
    }
}
