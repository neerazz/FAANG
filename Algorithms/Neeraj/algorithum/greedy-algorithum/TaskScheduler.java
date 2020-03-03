import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
//        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},2) + " should be [8]");
//        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},0) + " should be [6]");
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) + " should be [16]");
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    public static int leastInterval_wrong(char[] tasks, int n) {
        Arrays.sort(tasks);
        Map<Character, Integer> map = new HashMap<>();
        List<Task> queue = new ArrayList<>();
        int curValue = 0;
        for (int i = 0; i < tasks.length; i++) {
            char cur = tasks[i];
            if (map.containsKey(cur)) {
                int pre = map.get(cur);
                curValue = pre + n + 1;
            } else {
                curValue = 0;
            }
            map.put(cur, curValue);
            queue.add(new Task(cur, curValue));
        }
//        Sort the list.
        queue.sort(Comparator.comparingInt(t -> t.index));
        int processes = 0, pre = 0;
        for (Task task : queue) {
            if (task.index <= pre) {
                processes++;
            } else {
                processes += task.index - pre;
            }
            pre = task.index;
        }
//        System.out.println(queue);
        return processes;
    }

    static class Task {
        char value;
        int index;

        public Task(char value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
}
