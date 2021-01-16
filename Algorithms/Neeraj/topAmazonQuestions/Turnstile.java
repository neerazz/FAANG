import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/699973/
 */

public class Turnstile {

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(Arrays.toString(getTimes(new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
        System.out.println(Arrays.toString(getTimes(new int[]{1, 2, 4}, new int[]{0, 1, 1})));
        System.out.println(Arrays.toString(getTimes(new int[]{1, 1}, new int[]{1, 1})));
        System.out.println(Arrays.toString(getTimes(new int[]{1, 1, 3, 3, 4, 5, 6, 7, 7}, new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1})));

        System.out.println("Solution 2");
        System.out.println(Arrays.toString(getTimes(4, new int[]{0, 0, 1, 5}, new int[]{0, 1, 1, 0})));
        System.out.println(Arrays.toString(getTimes(4, new int[]{1, 2, 4}, new int[]{0, 1, 1})));
        System.out.println(Arrays.toString(getTimes(2, new int[]{1, 1}, new int[]{1, 1})));
        System.out.println(Arrays.toString(getTimes(9, new int[]{1, 1, 3, 3, 4, 5, 6, 7, 7}, new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1})));
    }

    public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        Queue<int[]> in = new LinkedList<>(), out = new LinkedList<>();
//        0: time, 1: idx
        for (int i = 0; i < arrTime.length; i++) {
            int time = arrTime[i], dir = direction[i];
            if (dir == 1) {
                out.add(new int[]{time, i});
            } else {
                in.add(new int[]{time, i});
            }
        }
        int[] times = new int[arrTime.length];
        int pre = 1, time = 0;
        while (!in.isEmpty() || !out.isEmpty()) {
            boolean hasIn = !in.isEmpty() && in.peek()[0] <= time;
            boolean hasOut = !out.isEmpty() && out.peek()[0] <= time;
            if (hasIn && hasOut) {
                if (pre == 1) {
//                    Let the person out
                    times[out.poll()[1]] = time;
                } else {
                    times[in.poll()[1]] = time;
                }
            } else if (hasIn) {
                times[in.poll()[1]] = time;
                pre = 0;
            } else if (hasOut) {
                times[out.poll()[1]] = time;
                pre = 1;
            } else {
                pre = 1;
            }
            time++;
        }
        return times;
    }

    private static int[] getTimes(int[] time, int[] dirs) {
        int len = time.length;
        int[] persons = new int[len];
        Queue<int[]> in = new LinkedList<>(), out = new LinkedList<>();
//        collect all the based on the directions.
        for (int i = 0; i < len; i++) {
            if (dirs[i] == 0) {
                in.add(new int[]{time[i], i});
            } else {
                out.add(new int[]{time[i], i});
            }
        }
        int t = 0, preDir = 1;
//        Set the initial direction to out, as that is the directions when pre was not used.
        while (!in.isEmpty() || !out.isEmpty()) {
//        Loop till both the queue is empty.
            boolean hasIn = !in.isEmpty() && in.peek()[0] <= t, hasOut = !out.isEmpty() && out.peek()[0] <= t;
            int inTime = Math.max(t, in.isEmpty() ? Integer.MAX_VALUE : in.peek()[0]);
            int outTime = Math.max(t, out.isEmpty() ? Integer.MAX_VALUE : out.peek()[0]);
            if (hasIn && hasOut) {
//                If there are two people at the same moment, then take the one with
                if (preDir == 1) {
                    persons[out.poll()[1]] = t;
                    t = outTime + 1;
                } else {
                    persons[in.poll()[1]] = t;
                    t = inTime + 1;
                }
            } else if (hasIn) {
                persons[in.poll()[1]] = t;
                preDir = 0;
                t = inTime + 1;
            } else if (hasOut) {
                persons[out.poll()[1]] = t;
                preDir = 1;
                t = outTime + 1;
            } else {
                preDir = 1;
                t++;
            }
        }
        return persons;
    }
}
