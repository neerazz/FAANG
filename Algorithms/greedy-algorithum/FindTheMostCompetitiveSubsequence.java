import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created on:  Jan 21, 2021
 * Questions: https://leetcode.com/problems/find-the-most-competitive-subsequence/
 */

public class FindTheMostCompetitiveSubsequence {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length, canRemove = len - k;
        Deque<Integer> stack = new LinkedList<>();
        for (int cur : nums) {
            while (!stack.isEmpty() && canRemove > 0 && stack.peekLast() > cur) {
                stack.removeLast();
                canRemove--;
            }
            stack.add(cur);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = stack.removeFirst();
        }
        return result;
    }

    //    Time: O(n^2), Space: k
    public static int[] mostCompetitive_naive(int[] nums, int k) {
        int len = nums.length, idx = 0, pre = -1;
        int[] result = new int[k];
        while (pre < len) {
            int min = Integer.MAX_VALUE, minIdx = pre;
            int rem = k - idx;
            for (int j = pre + 1; j < len - rem + 1; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
            }
            result[idx++] = min;
            pre = minIdx;
            if (idx == k) break;
        }
        return result;
    }
}
