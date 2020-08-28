package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created on:  Aug 26, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=510655302929581
 */
public class LargestTripleProducts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxProduct(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(findMaxProduct(new int[]{2, 1, 2, 1, 2})));
    }

    static int[] findMaxProduct(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            queue.add(arr[i]);
            if (queue.size() > 3) {
                queue.poll();
            }
            if (i < 2) result[i] = -1;
            else {
                int cur = 1;
                for (int val : queue) cur *= val;
                result[i] = cur;
            }
        }
        return result;
    }
}
