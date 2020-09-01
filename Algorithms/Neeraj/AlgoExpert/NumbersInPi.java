import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 31, 2020
 * Questions: https://www.algoexpert.io/questions/Numbers%20In%20Pi
 */
public class NumbersInPi {
    public static void main(String[] args) {

    }

    public static int numbersInPi(String pi, String[] numbers) {
        int len = pi.length();
        Set<String> set = new HashSet<>();
        for (String num : numbers) {
            set.add(num);
        }
        Integer[] dp = new Integer[len + 1];
        int result = helper(pi, 0, set, dp);
        return result == Integer.MAX_VALUE ? -1 : result - 1;
    }

    private static int helper(String pi, int idx, Set<String> set, Integer[] dp) {
        if (idx == pi.length()) return 0;
        if (dp[idx] != null) return dp[idx];
        int curBreaks = Integer.MAX_VALUE;
        String cur = "";
        for (int i = idx; i < pi.length(); i++) {
            cur += pi.charAt(i);
            if (set.contains(cur)) {
                int next = helper(pi, i + 1, set, dp);
                if (next != Integer.MAX_VALUE) curBreaks = Math.min(curBreaks, next + 1);
            }
        }
        return dp[idx] = curBreaks;
    }
}
