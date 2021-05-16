package weekly.weekly197;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/number-of-substrings-with-only-1s
 * Number of Substrings With Only 1s
 */
public class NumberOfSubstringsWithOnly1s {
    static int op, mod = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
        System.out.println(numSub("111111"));
    }

    public static int numSub_optimal(String s) {
        int res = 0, count = 0, mod = 1_000_000_007;
        for (char c : s.toCharArray()) {
            count = c == '1' ? count + 1 : 0;
            res = (res + count) % mod;
        }
        return res;
    }

    public static int numSub(String s) {
        op = 0;
        int len = s.length();
        for (int i = 1; i <= len; i++) {
            int res = formSubString(s, i);
            if (res == 0) break;
            op = (op + res) % mod;
        }
        return op;
    }

    private static int formSubString(String str, int cnt) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < cnt - 1; i++) {
            sum += (str.charAt(i) - '0');
        }
        int p1 = 0, p2 = cnt - 1;
        while (p2 < str.length()) {
            sum += (str.charAt(p2++) - '0');
            if (sum == cnt) count++;
            sum -= (str.charAt(p1++) - '0');
        }
        return count;
    }
}
