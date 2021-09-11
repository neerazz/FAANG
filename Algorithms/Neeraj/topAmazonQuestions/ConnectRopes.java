import java.util.PriorityQueue;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-connect-ropes
 */

public class ConnectRopes {

    public static void main(String[] args) {

    }

    public static int connectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) pq.add(rope);
        int cost = 0;
        while (pq.size() >= 2) {
            int a = pq.poll(), b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }
}
