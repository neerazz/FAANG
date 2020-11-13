import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 13, 2020
 * Questions: https://leetcode.com/problems/set-intersection-size-at-least-two/
 */

public class SetIntersectionSizeAtLeastTwo {

    public static void main(String[] args) {
        System.out.println(intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        System.out.println(intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}}));
    }

    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int set = 0, preStart = -1, preEnd = -1;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (start > preEnd) {
                set += 2;
                preStart = end - 1;
                preEnd = end;
            } else if (start > preStart) {
                set++;
                preStart = preEnd == end ? preEnd - 1 : preEnd;
                preEnd = end;
            }
        }
        return set;
    }
}
