import java.util.Collections;
import java.util.LinkedList;

/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/maximum-swap/
 */
public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap_optimal(2763) + " = " + maximumSwap(2763));
        System.out.println(maximumSwap_optimal(2736) + " = " + maximumSwap(2736));
    }

    //    https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
    public static int maximumSwap_optimal(int num) {
//        Collect all the chars in a list, and store the last digit of each index.
        LinkedList<Integer> nums = new LinkedList<>();
        int input = num;
        while (input > 0) {
            nums.addFirst(input % 10);
            input /= 10;
        }
//        Save last index of each digit.
        int[] dig = new int[10];
        for (int i = 0; i < nums.size(); i++) {
            dig[nums.get(i)] = i;
        }
        int op = 0;
        boolean swapped = false;
        for (int i = 0; i < nums.size(); i++) {
            if (!swapped) {
                int cur = nums.get(i);
                for (int j = 9; j > cur; j--) {
                    if (dig[j] > i) {
                        Collections.swap(nums, i, dig[j]);
                        swapped = true;
                        break;
                    }
                }
            }
            op = op * 10 + nums.get(i);
        }
        return op;
    }

    public static int maximumSwap(int num) {
        LinkedList<Integer> nums = new LinkedList<>();
        int input = num;
        while (input > 0) {
            nums.addFirst(input % 10);
            input /= 10;
        }
        int[][] maxVals = new int[nums.size()][2];
        int maxVal = 0, maxIdx = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) > maxVal) {
                maxVal = nums.get(i);
                maxIdx = i;
            }
            maxVals[i] = new int[]{maxVal, maxIdx};
        }
        for (int i = 0; i < nums.size(); i++) {
            if (maxVals[i][0] > nums.get(i)) {
                Collections.swap(nums, i, maxVals[i][1]);
                break;
            }
        }
        int op = 0;
        for (int val : nums) {
            op = op * 10 + val;
        }
        return op;
    }
}
