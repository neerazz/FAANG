package weekly.weekly237;

import java.util.*;

/**
 * Created on:  Apr 17, 2021
 * Questions:
 */

public class SingleThreadedCPU {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
//        System.out.println(Arrays.toString(getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));
//        System.out.println(Arrays.toString(getOrder(new int[][]{{1000000000, 1000000000}})));
        System.out.println(Arrays.toString(getOrder(new int[][]{{100, 100}, {1000000000, 1000000000}})));
    }

    public static int[] getOrder(int[][] tasks) {
        int curTime = 0, i2 = 0, len = tasks.length;
        int[] order = new int[len];
//        Collect all the tasks with index, and sort it in order of enqueueTime (start time)
        PriorityQueue<Task> orderedTasks = new PriorityQueue<>(Comparator.comparingInt(t -> t.start));
        for (int i = 0; i < len; i++) {
            orderedTasks.add(new Task(tasks[i][0], tasks[i][1], i));
        }
        PriorityQueue<Task> processor = new PriorityQueue<>((t1, t2) -> t1.time == t2.time ? Integer.compare(t1.idx, t2.idx) : Integer.compare(t1.time, t2.time));
        while (!orderedTasks.isEmpty()) {
            while (!orderedTasks.isEmpty() && orderedTasks.peek().start <= curTime) {
                processor.add(orderedTasks.poll());
            }
            if (!processor.isEmpty()) {
                Task poll = processor.poll();
                order[i2++] = poll.idx;
                curTime += poll.time;
            } else {
//                This is the key:
//                  If the process is empty, then instead of staying ideal. Move the current time to the next task start time.
                if (!orderedTasks.isEmpty()) curTime = orderedTasks.peek().start;
//                Break the while loop, when there are no any new tasks that can be added to queue.
                else break;
            }
        }
//        Collect all the tasks present in processor.
        while (!processor.isEmpty()) {
            order[i2++] = processor.poll().idx;
        }
        return order;
    }

    static class Task {
        int start, time, idx;

        public Task(int start, int time, int idx) {
            this.start = start;
            this.time = time;
            this.idx = idx;
        }
    }
}
