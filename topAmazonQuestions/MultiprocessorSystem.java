import java.util.PriorityQueue;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://algo.monster/problems/multiprocessor_system
 */

public class MultiprocessorSystem {

    public static void main(String[] args) {

    }

    public static int multiprocessorSystem(int[] ability, int num, int processes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2, p1));
        for (int cap : ability) {
            pq.add(cap);
        }
        int time = 0, processed = 0;
        while (!pq.isEmpty() && processed < processes) {
            int poll = pq.poll();
            processed += poll;
            time++;
            if (poll / 2 > 0) pq.add(poll / 2);
        }
        return time;
    }
}
