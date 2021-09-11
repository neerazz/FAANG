/**
 * Created on:  Sep 09, 2021
 * Ref: https://leetcode.com/problems/shifting-letters/
 */
public class ShiftingLetters {
    public static void main(String[] args) {

    }

    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        int[] postsum = new int[len];
        long sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += shifts[i];
            sum %= 26;
            postsum[i] = (int) sum;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(shift(s.charAt(i), postsum[i]));
        }
        return sb.toString();
    }

    char shift(char c, int shift) {
        int idx = (c - 'a') + shift;
        idx %= 26;
        return (char) ('a' + idx);
    }
}
