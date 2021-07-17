package RealAndMockInterview.pramp;

import java.util.PriorityQueue;
import java.util.Queue;

public class KMessedArray {


    static int[] sortKMessedArray(int[] arr, int k) {
        int counter = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                arr[counter++] = pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            arr[counter++] = pq.poll();
        }
        return arr;
    }

    public static void main(String[] args) {

    }

}
