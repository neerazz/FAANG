import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 *********************************");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A'}, 1) + " 5");
        System.out.println(leastInterval(new char[]{'A', 'A'}, 2) + " 4");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) + " 8");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) + " 6");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) + " 16");

        System.out.println("*************************** Solution 2 *********************************");
        System.out.println(leastInterval_rev1(new char[]{'A', 'A', 'A'}, 1) + " 5");
        System.out.println(leastInterval_rev1(new char[]{'A', 'A'}, 2) + " 4");
        System.out.println(leastInterval_rev1(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) + " 8");
        System.out.println(leastInterval_rev1(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) + " 6");
        System.out.println(leastInterval_rev1(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) + " 16");
    }

    public static int leastInterval_rev1(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t : tasks) {
            count[t - 'A']++;
        }
        PriorityQueue<Task> pq = new PriorityQueue<>(
                (t1, t2) -> t1.count == t2.count ? t1.end - t2.end : t2.count - t1.count
        );
        for (int i = 0; i < 26; i++) {
            Task task = new Task((char) ('A' + i));
            if (count[i] > 0) {
                task.count = count[i];
                pq.add(task);
            }
        }
        Map<Integer, Task> tMap = new HashMap<>();
        int time = 0, task = tasks.length;
        while (task > 0) {
            if (tMap.containsKey(time)) {
                pq.add(tMap.get(time));
            }
            if (!pq.isEmpty()) {
                Task poll = pq.poll();
                if (poll.count-- > 1) {
                    poll.end = time + n + 1;
                    tMap.put(poll.end, poll);
                }
                task--;
            }
            time++;
        }
        return time;
    }

    public static int leastInterval(char[] tasks, int n) {
        int result = 0;
        Map<Character, Task> map = new HashMap<>();
        for (char task : tasks) {
            map.computeIfAbsent(task, v -> new Task(task)).count++;
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> t1.count == t2.count ? t1.end - t2.end : t2.count - t1.count);

        pq.addAll(map.values());
        Map<Integer, Task> used = new HashMap<>();
        int task = tasks.length;
        while (task > 0) {
            Task pre = used.get(result);
            if (pre != null) pq.add(pre);
            if (!pq.isEmpty()) {
                Task cur = pq.poll();
                cur.end = result + n + 1;
                if (cur.count-- > 1) used.put(cur.end, cur);
                task--;
            }
            result++;
        }
        return result;
    }

    static class Task {
        char c;
        int count;
        int end;

        Task(char c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "c=" + c +
                    ", count=" + count +
                    ", next=" + end +
                    '}';
        }
    }
}
