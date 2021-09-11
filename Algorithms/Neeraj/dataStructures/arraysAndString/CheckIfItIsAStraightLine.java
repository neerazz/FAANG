/*
    Created on:  May 08, 2020
 */

/**
 * Questions: https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}) + " should be [true]");
        System.out.println(checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}) + " should be [false]");
        System.out.println(checkStraightLine(new int[][]{{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}}) + " should be [true]");
        System.out.println(checkStraightLine(new int[][]{{0, 1}, {1, 3}, {-4, -7}, {5, 11}}) + " should be [true]");
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
//        There can be three conditions for a like to be straight.
//        1. horizontal (y axis should be same),
//        2. vertical (x axis should be same),
//        3. It can be a diagonal line.
//              The property of a line to be diagonal is that the starting and current x-axis and y-axis difference. Should be same as the starting and second x-axis and y-axis difference.
        boolean isHorizontal = coordinates[0][0] == coordinates[1][0], isVertical = coordinates[0][1] == coordinates[1][1];
        int firstRatio = !isHorizontal && !isVertical ? (coordinates[1][0] - coordinates[0][0]) / (coordinates[1][1] - coordinates[0][1]) : -1;
        int[] pre = coordinates[0], start = coordinates[0];
        for (int i = 1; i < coordinates.length; i++) {
            int[] cur = coordinates[i];
            if (isHorizontal && pre[0] != cur[0]) return false;
            if (isVertical && pre[1] != cur[1]) return false;
            if (!isHorizontal && !isVertical) {
                int curRatio = cur[1] != pre[1] ? (cur[0] - pre[0]) / (cur[1] - pre[1]) : -1;
                if (curRatio == -1 || firstRatio != curRatio) return false;
            }
        }
        return true;
    }
}
