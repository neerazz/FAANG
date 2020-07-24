import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A'}, 1) + " 5");
        System.out.println(leastInterval(new char[]{'A', 'A'}, 2) + " 4");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) + " 8");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) + " 6");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) + " 16");
    }

    public static int leastInterval(char[] tasks, int n) {
        int result = 0;
        Map<Character, Task> map = new HashMap<>();
        for (char task : tasks) {
            map.computeIfAbsent(task, v -> new Task(task)).count++;
        }
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> t1.count == t2.count ? t1.next - t2.next : t2.count - t1.count);

        pq.addAll(map.values());
        Map<Integer, Task> used = new HashMap<>();
        int task = tasks.length;
        while (task > 0) {
            Task pre = used.get(result);
            if (pre != null) pq.add(pre);
            if (!pq.isEmpty()) {
                Task cur = pq.poll();
                cur.next = result + n + 1;
                if (cur.count-- > 1) used.put(cur.next, cur);
                task--;
            }
            result++;
        }
        return result;
    }

    static class Task {
        char c;
        int count;
        int next;

        Task(char c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "c=" + c +
                    ", count=" + count +
                    ", next=" + next +
                    '}';
        }
    }
}
