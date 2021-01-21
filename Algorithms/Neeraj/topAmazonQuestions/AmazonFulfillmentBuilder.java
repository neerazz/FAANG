import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 21, 2021
 * Questions:
 * It's similar to https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */

public class AmazonFulfillmentBuilder {

    public static void main(String[] args) {
        System.out.println(getTotalTime(new int[]{}));
    }

    private static int getTotalTime(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        int sum = 0;
        while (pq.size() >= 2) {
            int v1 = pq.poll(), v2 = pq.poll();
            sum += v1 + v2;
            pq.add(v1 + v2);
        }
        return sum;
    }
}
