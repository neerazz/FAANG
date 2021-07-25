package biweekly.biweekly57;

import java.util.PriorityQueue;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-57/problems/the-number-of-the-smallest-unoccupied-chair/
 */
public class TheNumberOfTheSmallestUnoccupiedChair {
    public static void main(String[] args) {

    }

    public int smallestChair(int[][] times, int targetFriend) {
//         0: index, 1 : entry time, 2: exit time
        PriorityQueue<int[]> entry = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
//         0: index, 1: exit, 2 : chair
        PriorityQueue<int[]> exit = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        int len = times.length;
        for (int i = 0; i < len; i++) {
            chairs.add(i);
            entry.add(new int[]{i, times[i][0], times[i][1]});
        }
        while (!entry.isEmpty()) {
            int[] poll = entry.poll();
            while (!exit.isEmpty() && exit.peek()[1] <= poll[1]) {
                chairs.add(exit.poll()[2]);
            }
            int nextAvailable = chairs.poll();
            if (poll[0] == targetFriend) {
                return nextAvailable;
            } else {
                exit.add(new int[]{poll[0], poll[2], nextAvailable});
            }
        }
        return -1;
    }
}
