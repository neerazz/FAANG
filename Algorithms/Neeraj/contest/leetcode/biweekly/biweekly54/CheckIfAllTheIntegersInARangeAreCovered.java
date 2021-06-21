package biweekly.biweekly54;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-54/problems/check-if-all-the-integers-in-a-range-are-covered/
 */

public class CheckIfAllTheIntegersInARangeAreCovered {

    public static void main(String[] args) {

    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                covered[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!covered[i]) return false;
        }
        return true;
    }
}
