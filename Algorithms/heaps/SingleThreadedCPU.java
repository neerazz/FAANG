import java.util.*;

/**
 * Created on:  Oct 11, 2021
 * Ref: https://leetcode.com/problems/single-threaded-cpu/
 */
public class SingleThreadedCPU {
    public static void main(String[] args) {

    }

    public static int[] getOrder(int[][] tasks) {
        PriorityQueue<Process> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.input, p2.input));
        int len = tasks.length;
        for (int i = 0; i < len; i++) {
            queue.add(new Process(i, tasks[i][0], tasks[i][1]));
        }
        int[] result = new int[len];
        int i = 0, curTime = 0, freeTime = 0;
        PriorityQueue<Process> waiting = new PriorityQueue<>((p1, p2) -> p1.time == p2.time ? Integer.compare(p1.idx, p2.idx) : Integer.compare(p1.time, p2.time));
        while (i < len) {
            // check all tasks that was queued before time, add it to waiting
            while (!queue.isEmpty() && queue.peek().input <= curTime) {
                waiting.add(queue.poll());
            }
//            If there is nothing in waiting list, then run the current time till the next task entry time.
            if (waiting.isEmpty()) {
                curTime = queue.peek().input;
            } else {
                Process poll = waiting.poll();
                result[i++] = poll.idx;
                curTime += poll.time;
            }
        }
        return result;
    }

    static class Process {
        int idx, input, time;

        Process(int i, int e, int p) {
            idx = i;
            input = e;
            time = p;
        }
    }
}
