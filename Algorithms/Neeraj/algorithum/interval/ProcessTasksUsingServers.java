import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/process-tasks-using-servers/
 */
public class ProcessTasksUsingServers {
    public static void main(String[] args) {
        System.out.println();
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<Task> queue = new LinkedList<>();
        int tlen = tasks.length, slen = servers.length;
        for (int i = 0; i < tlen; i++) {
            queue.add(new Task(i, tasks[i]));
        }
        // [free_time, serverIdx, weight]
        PriorityQueue<int[]> free = new PriorityQueue<>((s1, s2) -> s1[2] == s2[2] ? Integer.compare(s1[1], s2[1]) : Integer.compare(s1[2], s2[2]));
        PriorityQueue<int[]> busy = new PriorityQueue<>((s1, s2) -> Integer.compare(s1[0], s2[0]));
        int[] result = new int[tlen];
        for (int i = 0; i < slen; i++) {
            free.add(new int[]{0, i, servers[i]});
        }
        int time = 0;
        while (!queue.isEmpty()) {
            // check the busy server, if it can be freed.
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.add(busy.poll());
            }
            if (free.isEmpty()) {
                // if there are no any free servers to process then skip the time till the next server is avilable
                time = busy.peek()[0];
                continue;
            }
            int[] server = free.poll();
            Task task = queue.poll();
            result[task.idx] = server[1];
            server[0] = time + task.time;
            busy.add(server);
            time++;
        }
        return result;
    }

    static class Task {
        int idx, time;

        Task(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}
