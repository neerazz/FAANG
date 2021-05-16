package biweekly.biweekly31;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/number-of-good-ways-to-split-a-string
 */
public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {

    }

    public static int numSplits(String s) {
        int result = 0;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] cur = new int[26];
        for (char c : s.toCharArray()) {
            cur[c - 'a']++;
            if (canFormGood(cur, count)) {
                result++;
            }
        }
        return result;
    }

    private static boolean canFormGood(int[] cur, int[] total) {
        int left = 0, right = 0;
        for (int num : cur) {
            if (num > 0) left++;
        }
        for (int i = 0; i < 26; i++) {
            if (total[i] - cur[i] > 0) {
                right++;
            }
        }
        return left == right;
    }
}
