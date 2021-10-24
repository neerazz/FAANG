import java.util.PriorityQueue;

/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/B6x69OLX4jY
 */

public class MaximizeCapital {

    //    Time : O(n Log n) + O(k Log n) , Space: O(n). Where K is number of project that can be purchased, and n is number of projects in the input.
    public static int findMaximumCapital_2(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
//        0: capital, 1 : profit
        PriorityQueue<int[]> capitalPq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
        PriorityQueue<int[]> profitPq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[1], p1[1]));
        int total = initialCapital, len = capital.length;
        for (int i = 0; i < len; i++) {
            capitalPq.add(new int[]{capital[i], profits[i]});
        }
        while (numberOfProjects > 0) {
//            Add all the projects from capital that can be bought, add add those to the profits.
            while (!capitalPq.isEmpty() && capitalPq.peek()[0] <= total) {
                profitPq.add(capitalPq.poll());
            }
//            Now take the project that has max profit.
            if (!profitPq.isEmpty()) {
                total += profitPq.poll()[1];
                numberOfProjects--;
            }
        }
        return total;
    }

    //    Time : O(kn), Space: O(n). Where K is number of project that can be purchased, and n is number of projects in the input.
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int len = capital.length;
        boolean[] taken = new boolean[len];
        int total = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            int maxProfit = Integer.MIN_VALUE, maxIdx = -1;
            for (int j = 0; j < len; j++) {
                if (taken[j]) continue;
                if (capital[j] <= total && maxProfit < profits[j]) {
                    maxProfit = profits[j];
                    maxIdx = j;
                }
            }
            total += maxProfit;
            taken[maxIdx] = true;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 ***************************");
        System.out.println("Maximum capital: " + findMaximumCapital(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1));
        System.out.println("Maximum capital: " + findMaximumCapital(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 5}, 3, 0));

        System.out.println("****************************** Solution 2 ***************************");
        System.out.println("Maximum capital: " + findMaximumCapital_2(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1));
        System.out.println("Maximum capital: " + findMaximumCapital_2(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 5}, 3, 0));
    }
}
