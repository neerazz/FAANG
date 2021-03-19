package jacobo.phone2;

import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 16, 2021
 * Questions:
 * ESCALATION PROBLEM:
 * 4 programs can be running at any given time.
 * <p>
 * Already Scheduled: P1(10, 5), P2(5, 15), P3(20, 15), P4(18, 6), P5(15, 5), P6(12, 9)
 * <p>
 * New Program: Q1 (14, 3) => can schedule
 * New Program: Q2 (18, 3) => cannot schedule
 * <p>
 * P1(10, 5), P2(5, 15), P3(20, 15), P4(18, 6), P5(15, 5), P6(12, 9), P7(23,5)
 * <p>
 * <p>
 * Scheduled:
 * *          10----15
 * *     5--------------20
 * *                    20---------------35
 * *                  18------23
 * *             15-----20
 * *                      22-----28
 * *          12---------21
 */

public class Q2 {

    public static void main(String[] args) {
        System.out.println(canScheduleNewJob(new int[][]{{10, 5}, {5, 15}, {20, 15}, {18, 6}, {15, 5}, {12, 9}, {23, 5}}, new int[]{21, 2}) + " = true");
        System.out.println(canScheduleNewJob(new int[][]{{10, 5}, {5, 15}, {20, 15}, {18, 6}, {15, 5}, {12, 9}, {23, 5}}, new int[]{14, 3}) + " = false");
        System.out.println(canScheduleNewJob(new int[][]{{10, 5}, {5, 15}, {20, 15}, {18, 6}, {15, 5}, {12, 9}, {23, 5}}, new int[]{18, 3}) + " = false");
    }

    private static boolean canScheduleNewJob(int[][] scheduled, int[] newJob) {
        List<Integer> starts = new ArrayList<>(), ends = new ArrayList<>();
        int max = 0;
        for (int[] job : scheduled) {
            int start = job[0], end = start + job[1];
            starts.add(start);
            ends.add(end);
            max = Math.max(max, end);
        }
//        Mark the starts and end of a task on a plot
        int[] dp = new int[max + 1];
        for (int i = 0; i < starts.size(); i++) {
            int start = starts.get(i), end = ends.get(i);
            dp[start]++;
            if (end + 1 < dp.length) dp[end + 1]--;
        }
//        Run though the plot and calculate the number of jobs running at each instance.
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = sum += dp[i];
        }
//        Run through the new job range and see if a new job can be fit, For a new job to fit the max jobs between start and end instance should be at max 3.
        max = 0;
        for (int i = newJob[0]; i <= newJob[0] + newJob[1]; i++) {
            max = Math.max(max, dp[i]);
        }
        return max < 4;
    }
}