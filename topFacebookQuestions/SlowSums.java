import java.util.PriorityQueue;

/**
 * Created on:  Sep 07, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=836241573518034
 */
public class SlowSums {
    public static void main(String[] args) {

    }

    static int getTotalTime(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int val : arr) pq.add(val);
        int max = pq.poll(), result = 0;
        while (!pq.isEmpty()) {
            max += pq.poll();
            result += max;
            pq.add(max);
            max = pq.poll();
        }
        return result;
    }
}
