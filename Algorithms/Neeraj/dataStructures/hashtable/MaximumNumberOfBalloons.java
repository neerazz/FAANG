/**
 * Created on:  Sep 13, 2021
 * Ref: https://leetcode.com/problems/maximum-number-of-balloons
 */
public class MaximumNumberOfBalloons {
    char[] chars = {'b', 'a', 'l', 'o', 'n'};

    public static void main(String[] args) {

    }

    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (char c : chars) {
            int count = counts[c - 'a'];
            if (c == 'l' || c == 'o') {
                count /= 2;
            }
            min = Math.min(min, count);
        }
        return min;
    }
}
