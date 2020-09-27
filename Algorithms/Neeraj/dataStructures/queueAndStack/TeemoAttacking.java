/**
 * Created on:  Sep 26, 2020
 * Questions: https://leetcode.com/problems/teemo-attacking/
 */
public class TeemoAttacking {
    public static void main(String[] args) {

    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int free = 0, total = 0;
        for (int time : timeSeries) {
            free = Math.max(free, time);
            int cur = time + duration;
            total += (time + duration) - free;
            free = cur;
        }
        return total;
    }
}
