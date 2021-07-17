package contests.leetcode.biweekly28;

import java.util.PriorityQueue;
import java.util.Queue;

//TODO:SACHIN::WRONG Answer
public class MinSumOfLengths {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8};
        int target = 5;
        System.out.println(minSumOfLengths(arr, target));
    }

    public static int minSumOfLengths(int[] arr, int target) {
        Queue<Integer> pq = new PriorityQueue<>();
        //Find all subarrays
        int sum = 0, counter = 0;
        for (Integer i : arr) {
            sum += i;
            counter++;
            if (sum > target) {
                counter = 1;
                sum = i;
            }
            if (sum == target) {
                pq.add(counter);
                sum = 0;
                counter = 0;
            }
        }
        if (pq.size() < 2) {
            return -1;
        } else {
            return pq.poll() + pq.poll();
        }
    }

}
