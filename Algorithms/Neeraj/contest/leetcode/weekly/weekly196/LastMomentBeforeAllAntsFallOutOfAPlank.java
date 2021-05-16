package weekly.weekly196;

/**
 * Created on:  Jul 04, 2020
 * Questions: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank
 */
public class LastMomentBeforeAllAntsFallOutOfAPlank {
    public static void main(String[] args) {
        System.out.println(getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}) + " should be [4].");
        System.out.println(getLastMoment(7, new int[0], new int[]{0, 1, 2, 3, 4, 5, 6, 7}) + " should be [7].");
        System.out.println(getLastMoment(7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[0]) + " should be [7].");
        System.out.println(getLastMoment(9, new int[]{5}, new int[]{4}) + " should be [5].");
    }

    public static int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int num : left) {
            max = Math.max(max, num);
        }
        for (int num : right) {
            max = Math.max(max, n - num);
        }
        return max;
    }
}
