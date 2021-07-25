package biweekly.biweekly57;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-57/problems/number-of-visible-people-in-a-queue/
 */
public class NumberOfVisiblePeopleInAQueue {
    public static void main(String[] args) {

    }

    public static int[] canSeePersonsCount_naive(int[] heights) {
        int len = heights.length;
        int[] counts = new int[len];
        for (int i = 0; i < len; i++) {
            int max = 0, count = 0;
            for (int j = i + 1; j < len; j++) {
                if (Math.min(heights[j], heights[i]) > max) {
                    count++;
                }
                max = Math.max(max, heights[j]);
            }
            counts[i] = count;
        }
        return counts;
    }
}
