package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created on:  Aug 26, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=547645422524434
 */
public class MedianStream {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMedian(new int[]{5, 15, 1, 3})));
    }

    static int[] findMedian(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> left = new PriorityQueue<>((v1, v2) -> v2 - v1), right = new PriorityQueue<>();
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (!left.isEmpty()) right.add(left.poll());
            right.add(arr[i]);
//            Always make sure that left have more numbers then right.
            while (left.size() < right.size()) left.add(right.poll());
            if (i % 2 == 0) {
//                Then there are odd size, take only from left.
                result[i] = left.peek();
            } else {
                result[i] = (left.peek() + right.peek()) / 2;
            }
        }
        return result;
    }
}
