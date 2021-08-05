package blind75.interval;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/merge-intervals/
F
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeInterval {

    public static int[][] merge(int[][] intervals) {
        //Only 1 value - Just return it
        if (intervals == null || intervals.length < 2) return intervals;
        List<int[]> sol = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int pstart = intervals[0][0];
        int pend = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // No overlap
            if (intervals[i][0] > pend) {
                sol.add(new int[]{pstart, pend});
                pstart = intervals[i][0];
                pend = intervals[i][1];
                //Overlap
            } else if (intervals[i][0] <= pend) {
                pstart = Math.min(pstart, intervals[i][0]);
                pend = Math.max(pend, intervals[i][1]);
            }
        }
        sol.add(new int[]{pstart, pend});
        return sol.toArray(new int[sol.size()][2]);
    }

    public static void main(String[] args) {
        //int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] input = new int[][]{{1, 4}, {5, 6}};
        int[][] sol = merge(input);
        Util.print(sol);
    }

}
