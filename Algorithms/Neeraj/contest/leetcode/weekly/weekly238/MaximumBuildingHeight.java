package weekly.weekly238;

import java.util.*;

/**
 * Created on:  Apr 24, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-238/problems/maximum-building-height/
 */

public class MaximumBuildingHeight {

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 *****************************");
        System.out.println(maxBuilding(5, new int[][]{{2, 1}, {4, 1}}) + " = 2");
        System.out.println(maxBuilding(6, new int[0][0]) + " = 5");
        System.out.println(maxBuilding(10, new int[][]{{5, 3}, {2, 5}, {7, 4}, {10, 3}}) + " = 5");
        System.out.println(maxBuilding(10, new int[][]{{8, 5}, {9, 0}, {6, 2}, {4, 0}, {3, 2}, {10, 0}, {5, 3}, {7, 3}, {2, 4}}) + " = 2");
        System.out.println(maxBuilding(10, new int[][]{{6, 0}, {5, 2}, {7, 0}, {9, 1}, {2, 4}, {3, 4}, {4, 0}, {8, 2}, {10, 0}}) + " = 1");
        System.out.println(maxBuilding(100, new int[][]{{68, 29}, {89, 27}, {66, 26}, {34, 9}, {53, 23}, {93, 24}, {70, 12}, {25, 24}, {5, 4}, {94, 41}, {51, 42}, {6, 39}, {55, 21}, {69, 9}, {39, 50}, {99, 42}, {77, 24}, {81, 46}, {90, 43}, {27, 14}, {31, 5}, {67, 37}, {82, 10}, {26, 47}, {84, 34}, {37, 30}, {83, 39}, {21, 39}, {49, 39}, {13, 48}, {12, 34}, {57, 0}, {7, 43}, {17, 6}, {23, 0}, {86, 30}, {47, 30}, {61, 19}, {30, 49}, {95, 42}, {3, 31}, {33, 36}, {11, 45}, {75, 39}, {85, 46}, {29, 33}, {2, 9}, {22, 17}, {65, 42}, {96, 0}, {35, 46}, {88, 47}, {74, 0}, {73, 47}, {41, 45}, {15, 21}, {97, 0}, {64, 0}, {40, 21}, {76, 2}, {54, 3}, {24, 33}, {45, 24}, {16, 23}, {91, 14}, {43, 35}, {79, 6}, {46, 30}, {71, 3}, {9, 39}, {50, 21}, {48, 45}, {63, 42}, {58, 3}, {10, 26}, {4, 6}, {52, 19}, {32, 39}, {87, 50}, {8, 48}, {19, 25}, {92, 1}, {28, 21}, {59, 31}, {72, 24}, {78, 9}, {100, 8}, {60, 20}, {42, 16}, {38, 8}, {62, 31}, {36, 22}, {44, 27}, {14, 45}, {18, 3}, {98, 0}, {20, 1}, {56, 24}, {80, 3}}) +
                " = 13");
        System.out.println("****************************** Solution 2 *****************************");
        System.out.println(maxBuilding_rev2(5, new int[][]{{2, 1}, {4, 1}}) + " = 2");
        System.out.println(maxBuilding_rev2(6, new int[0][0]) + " = 5");
        System.out.println(maxBuilding_rev2(10, new int[][]{{5, 3}, {2, 5}, {7, 4}, {10, 3}}) + " = 5");
        System.out.println(maxBuilding_rev2(10, new int[][]{{8, 5}, {9, 0}, {6, 2}, {4, 0}, {3, 2}, {10, 0}, {5, 3}, {7, 3}, {2, 4}}) + " = 2");
        System.out.println(maxBuilding_rev2(10, new int[][]{{6, 0}, {5, 2}, {7, 0}, {9, 1}, {2, 4}, {3, 4}, {4, 0}, {8, 2}, {10, 0}}) + " = 1");
        System.out.println(maxBuilding_rev2(100, new int[][]{{68, 29}, {89, 27}, {66, 26}, {34, 9}, {53, 23}, {93, 24}, {70, 12}, {25, 24}, {5, 4}, {94, 41}, {51, 42}, {6, 39}, {55, 21}, {69, 9}, {39, 50}, {99, 42}, {77, 24}, {81, 46}, {90, 43}, {27, 14}, {31, 5}, {67, 37}, {82, 10}, {26, 47}, {84, 34}, {37, 30}, {83, 39}, {21, 39}, {49, 39}, {13, 48}, {12, 34}, {57, 0}, {7, 43}, {17, 6}, {23, 0}, {86, 30}, {47, 30}, {61, 19}, {30, 49}, {95, 42}, {3, 31}, {33, 36}, {11, 45}, {75, 39}, {85, 46}, {29, 33}, {2, 9}, {22, 17}, {65, 42}, {96, 0}, {35, 46}, {88, 47}, {74, 0}, {73, 47}, {41, 45}, {15, 21}, {97, 0}, {64, 0}, {40, 21}, {76, 2}, {54, 3}, {24, 33}, {45, 24}, {16, 23}, {91, 14}, {43, 35}, {79, 6}, {46, 30}, {71, 3}, {9, 39}, {50, 21}, {48, 45}, {63, 42}, {58, 3}, {10, 26}, {4, 6}, {52, 19}, {32, 39}, {87, 50}, {8, 48}, {19, 25}, {92, 1}, {28, 21}, {59, 31}, {72, 24}, {78, 9}, {100, 8}, {60, 20}, {42, 16}, {38, 8}, {62, 31}, {36, 22}, {44, 27}, {14, 45}, {18, 3}, {98, 0}, {20, 1}, {56, 24}, {80, 3}}) +
                " = 13");
    }

    //    https://leetcode.com/problems/maximum-building-height/discuss/1175058/Java-O(1)-space-O(klogk)-time-with-comments.
    public static int maxBuilding_rev2(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (v1, v2) -> Integer.compare(v1[0], v2[0]));
        int len = restrictions.length;
//        Starting Index and starting height.
        int[] left = {1, 0};
//        Keep calculating the max height that can be achieved from left to right.
        for (int[] cur : restrictions) {
//            Max height at current can be:
//              The height at left + cur distance from left. (Assuming that building height is continuously increased from left to cur)
            int curHeight = Math.min(cur[1], left[1] + (cur[0] - left[0]));
            cur[1] = curHeight;
            left = cur;
        }
//        The nth building height can be at max n-1;
        int[] right = {n, n - 1};
//        Keep calculating the max height that can be achieved from right to left.
        for (int i = len - 2; i >= 0; i--) {
            int[] cur = restrictions[i];
            int curHeight = Math.min(cur[1], right[1] + (right[0] - cur[0]));
            cur[1] = curHeight;
            right = cur;
        }
        int max = 0;
        int[] pre = {1, 0};
        for (int[] cur : restrictions) {
            int maxHeight = getMaxHeight_2(pre, cur);
            max = Math.max(max, maxHeight);
            pre = cur;
        }
//        The maximum height after the end of restrictions.
        int maxHeight = pre[1] + (n - pre[0]);
        max = Math.max(max, maxHeight);
        return max;
    }

    private static int getMaxHeight_2(int[] pre, int[] cur) {
        //example:   pre_idx = 1, pre_height = 1, cur_idx = 6, cur_height = 2
        // reaching height 1 to height 2 only needs 1 step, but we have (6-1) - 1 = 4 remaining steps
        // we can use the 4 remaining steps to go higher first then back down.
        // The steps are, first move up to 2, then we have 4 steps, go 2 up to height 4, then 2 down back to 2, so highest is 4
        //H    1 2 3 3 2
        //ind  1       6
        int min = Math.min(pre[1], cur[1]), max = Math.max(pre[1], cur[1]);
        int dist = cur[0] - pre[0];
        int remaining = Math.max(0, dist - (max - min));
//        If there are no any remaining steps then, then the max will be the minimum of those buildings.
        return max + remaining / 2;
    }

    public static int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (v1, v2) -> Integer.compare(v1[0], v2[0]));
        int len = restrictions.length;
//        Starting Index and starting height.
        int[] left = {1, 0};
//        Keep calculating the max height that can be achieved from left to right.
        for (int[] cur : restrictions) {
//            Max height at current can be:
//              The height at left + cur distance from left. (Assuming that building height is continuously increased from left to cur)
            int curHeight = Math.min(cur[1], left[1] + (cur[0] - left[0]));
            cur[1] = curHeight;
            left = cur;
        }
//        The nth building height can be at max n-1;
        int[] right = {n, n - 1};
//        Keep calculating the max height that can be achieved from right to left.
        for (int i = len - 2; i >= 0; i--) {
            int[] cur = restrictions[i];
            int curHeight = Math.min(cur[1], right[1] + (right[0] - cur[0]));
            cur[1] = curHeight;
            right = cur;
        }
        int max = 0;
        int[] pre = {1, 0};
        int[] heights = new int[n + 1];
        for (int[] cur : restrictions) {
            max = Math.max(max, getMaxHeight(pre, cur, heights));
            pre = cur;
        }
        max = Math.max(max, getMaxHeight(pre, new int[]{n, n - 1}, heights));
//        System.out.println("heights = " + Arrays.toString(heights));
        return max;
    }

    private static int getMaxHeight(int[] pre, int[] cur, int[] heights) {
//        Max height that can be achieved between buildings, with the height restrictions of pre & cur.
        int len = cur[0] - pre[0] + 1, max = 0;
        int[] left = new int[len], right = new int[len];
        left[0] = pre[1];
        right[len - 1] = cur[1];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] + 1;
        }
        for (int i = 0; i < len; i++) {
            int curHeight = Math.min(left[i], right[i]);
            heights[pre[0] + i] = curHeight;
            max = Math.max(max, curHeight);
        }
        return max;
    }

    public static int maxBuilding_naive(int n, int[][] restrictions) {
        int[] heights = new int[n + 1];
        Arrays.fill(heights, n - 1);
        heights[0] = heights[1] = 0;
        Arrays.sort(restrictions, (v1, v2) -> Integer.compare(v1[0], v2[0]));
        for (int[] restriction : restrictions) {
            int cur = restriction[0], pre = restriction[0] - 1;
            heights[cur] = restriction[1];
            while (pre > 0 && Math.abs(heights[pre] - heights[cur]) > 1) {
                int min = Math.min(heights[pre], heights[cur]);
                if (heights[pre] != min) heights[pre] = min + 1;
                if (heights[cur] != min) heights[cur] = min + 1;
                pre--;
                cur--;
            }
        }
        int cur = n, pre = cur - 1;
        while (pre > 0 && Math.abs(heights[pre] - heights[cur]) > 1) {
            int min = Math.min(heights[pre], heights[cur]);
            if (heights[pre] != min) heights[pre] = min + 1;
            if (heights[cur] != min) heights[cur] = min + 1;
            pre--;
            cur--;
        }
//        System.out.println("heights = " + Arrays.toString(heights));
        return Arrays.stream(heights).max().getAsInt();
    }
}
