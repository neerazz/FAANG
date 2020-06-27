package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class LargestRectangleUnderSkyline {
    @EpiTest(testDataFile = "largest_rectangle_under_skyline.tsv")

    public static int calculateLargestRectangle(List<Integer> heights) {
        int max = 0, len = heights.size();
        for (int i = 0; i < len; i++) {
            int cur = expandAndGetMax(heights, i, len);
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    private static int expandAndGetMax(List<Integer> heights, int idx, int len) {
        int left = idx, right = idx, cur = heights.get(idx);
        while (left >= 0 && heights.get(left) >= cur) left--;
        while (right < len && heights.get(right) >= cur) right++;
        return cur * (right - left - 1);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LargestRectangleUnderSkyline.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
