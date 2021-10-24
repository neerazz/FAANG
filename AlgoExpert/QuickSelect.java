import java.util.PriorityQueue;

/**
 * Created on:  Sep 06, 2020
 * Questions: https://www.algoexpert.io/questions/Quickselect
 */
public class QuickSelect {
    public static void main(String[] args) {

    }

    public static int quickselect(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int val : array) {
            pq.add(val);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
