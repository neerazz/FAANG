package practice;

import java.util.PriorityQueue;

/**
 * Created on:  Aug 26, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=513590792640579
 */
public class MagicalCandyBags {
    public static void main(String[] args) {
        System.out.println(maxCandies(new int[]{2, 1, 7, 4, 2}, 3));
    }

    //    Time : n log n + k log n, space: O(n)
    static int maxCandies(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int val : arr) {
            queue.add(val);
        }
        int count = 0;
        while (k > 0 && !queue.isEmpty() && queue.peek() > 0) {
            int poll = queue.poll();
            count += poll;
            queue.add(poll / 2);
            k--;
        }
        return count;
    }
}
