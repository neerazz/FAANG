package weekly.weekly213;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-213/problems/furthest-building-you-can-reach/
 */

public class FurthestBuildingYouCanReach {


    private static int max;

    public static void main(String[] args) {

    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        max = 0;
//        Integer[][][] dp = new Integer[len + 1][bricks + 1][ladders + 1];
//        helper(heights, 0, bricks, ladders, dp);
        int[][][] dp = new int[len][2][Math.max(bricks + 1, ladders + 1)];
        for (int i = 1; i < len; i++) {

        }
        return max;
    }

    private static void helper(int[] heights, int idx, int bricks, int ladders, Integer[][][] dp) {
        if (idx == heights.length - 1) {
            max = idx;
            return;
        }
        if (bricks < 0 || ladders < 0) return;
        max = Math.max(max, idx);
        int cur = heights[idx], next = heights[idx + 1];
        if (cur >= next) {
            helper(heights, idx + 1, bricks, ladders, dp);
        } else {
//            if you can make a take bricks and go to next take it.
            if (bricks >= next - cur) {
                helper(heights, idx + 1, bricks - (next - cur), ladders, dp);
            }
//            If you can take ladder then take it and give a try.
            if (ladders > 0) {
                helper(heights, idx + 1, bricks, ladders - 1, dp);
            }
        }
    }
}
