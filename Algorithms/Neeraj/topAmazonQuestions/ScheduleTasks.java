import java.util.PriorityQueue;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/896000198
 */

public class ScheduleTasks {

    public static void main(String[] args) {
        System.out.println(getTaskResolveTime(5, new int[]{4, 2, 8, 3, 5}, 19));
        System.out.println(getTaskResolveTime(4, new int[]{4, 8, 3, 5}, 25));
    }

    private static int getTaskResolveTime(int n, int[] powers, int tasks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2, p1));
        for (int power : powers) if (power > 0) pq.add(power);
        int time = 0;
        while (tasks > 0 && !pq.isEmpty()) {
            int power = pq.poll();
            time++;
            tasks -= power;
            if (power / 2 > 0) pq.add(power / 2);
        }
        return tasks <= 0 ? time : -1;
    }
}
