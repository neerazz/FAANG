import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/discuss/interview-question/915683/
 */

public class MaxSumOfNumbersWithSameDigitSum {

    public static void main(String[] args) {
        System.out.println(getMaxSum(new int[]{60, 42, 35}));
        System.out.println(getMaxSum(new int[]{42, 33, 60}));
    }

    private static int getMaxSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> sameSumDigits = new HashMap<>();
        for (int num : nums) {
            int sum = getDigitSum(num);
            sameSumDigits.computeIfAbsent(sum, val -> new PriorityQueue<>()).add(num);
            if (sameSumDigits.get(sum).size() > 2) {
//                Remove the smallest one. So that at any time there are only two numbers that gives maximum sum
                sameSumDigits.get(sum).poll();
            }
        }
        int max = 0;
        for (PriorityQueue<Integer> pairs : sameSumDigits.values()) {
            if (pairs.size() == 1) continue;
            max = Math.max(max, pairs.poll() + pairs.poll());
        }
        return max;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
            if (sum > 10) {
                sum = (sum / 10) + (sum % 10);
            }
        }
        return sum;
    }
}
