import java.util.*;

/**
 * Created on:  Jul 08, 2021
 * Ref:
 */

public class MaximumCPULoad {

    public static int findMaxCPULoad_2(List<Job> jobs) {
        jobs.sort(Comparator.comparingInt(j -> j.start));
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> Integer.compare(j1.end, j2.end));
        int max = 0, total = 0;
        for (Job job : jobs) {
            while (!pq.isEmpty() && pq.peek().end <= job.start) {
                total -= pq.poll().cpuLoad;
            }
            pq.add(job);
            total += job.cpuLoad;
            max = Math.max(max, total);
        }
        return max;
    }

    public static int findMaxCPULoad(List<Job> jobs) {
        List<int[]> tasks = new ArrayList<>();
        // 0: (1/-1), 1: time, 2 : load
        for (Job job : jobs) {
            tasks.add(new int[]{1, job.start, job.cpuLoad});
            tasks.add(new int[]{-1, job.end, job.cpuLoad});
        }
        Comparator<int[]> order = (t1, t2) -> t1[1] == t2[1] ? Integer.compare(t1[0], t2[0]) : Integer.compare(t1[1], t2[1]);
        Collections.sort(tasks, order);
        int total = 0;
        Map<Integer, Integer> loads = new HashMap<>();
        for (int[] task : tasks) {
            total += task[2] * task[0];
            loads.put(task[1], total);
        }
        return loads.values().stream().mapToInt(val -> val).max().getAsInt();
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }

    static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }
}
