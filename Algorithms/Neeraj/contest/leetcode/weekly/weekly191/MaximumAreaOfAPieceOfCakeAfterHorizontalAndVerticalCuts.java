package weekly.weekly191;

import java.util.*;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}) + " should be [4]");
        System.out.println(maxArea(5, 4, new int[]{3, 1}, new int[]{1}) + " should be [6]");
        System.out.println(maxArea(5, 4, new int[]{3}, new int[]{3}) + " should be [9]");
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        int hMax = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            hMax = Math.max(hMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        hMax = Math.max(hMax, h - horizontalCuts[horizontalCuts.length - 1]);
        Arrays.sort(verticalCuts);
        int vMax = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            vMax = Math.max(vMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        vMax = Math.max(vMax, w - verticalCuts[verticalCuts.length - 1]);
        return (int) (((long) hMax * vMax) % 1_000_000_007);
    }
}
