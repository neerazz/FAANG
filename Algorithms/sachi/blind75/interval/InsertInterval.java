package blind75.interval;

import util.Util;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval/
F
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Example 3:
Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]

Example 4:
Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]

Example 5:
Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]

 */
public class InsertInterval {

    public static class Interval {
        public int start;
        public int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        Interval() {
        }
    }

    //First compare -> End of Full -> Start of new
    //When overlapping Start of Full -> End of new
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> sol = new ArrayList<>();
        int i = 0;

        //All Intervals start and end before newInterval
        while (i < intervals.size() && intervals.get(i).start < newInterval.end) {
            sol.add(intervals.get(i));
            i++;
        }

        //Find the overlapping Interval -
        Interval insertInterval = new Interval();
        while (i < intervals.size() && intervals.get(i).start < newInterval.end) {
            insertInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end)
            );
            i++;
        }
        sol.add(insertInterval);

        while (i < intervals.size()) {
            sol.add(intervals.get(i));
            i++;
        }

        return sol;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        int i = 0;
        //[1,3]
        //   [2 ,6]
        //Copy all non overlapping windows to solution
        while (i < intervals.length && intervals[i][1] < start) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        //[1,   3] [4    8]
        //   [2       6]
        //When overlapping
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        list.add(new int[]{start, end});

        //Copy non overlapping after the answer
        while (i < intervals.length) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }




    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] sol = insert(input, newInterval);
        Util.print(sol);
    }

}
