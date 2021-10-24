import java.util.TreeSet;

/**
 * Created on:  Jan 30, 2021
 * Questions: https://leetcode.com/problems/minimize-deviation-in-array/
 */

public class MinimizeDeviationInArray {

    public static void main(String[] args) {

    }

    public static int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int min = Integer.MAX_VALUE;
//        Get the smallest Min values
        for (int num : nums) {
            if (num % 2 == 1) num *= 2;
            set.add(num);
            min = Math.min(num, min);
        }
        int result = Integer.MAX_VALUE;
        while (!set.isEmpty()) {
            int cur = set.pollLast();
//            Calculate the new deviation
            result = Math.min(result, cur - min);
//            Once you find a max value that is odd then, break it (Because odds cannot be reduced).
            if (cur % 2 == 1) break;
            set.add(cur / 2);
            min = Math.min(min, cur / 2);
        }
        return result;
    }
}
