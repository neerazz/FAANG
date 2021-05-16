package weekly.weekly227;

import java.util.*;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class MaximumScoreFromRemovingStones {

    public static void main(String[] args) {
        System.out.println(maximumScore(1079, 597, 575));
        System.out.println(maximumScore(2003, 1652, 2013));
    }

    public static int maximumScore(int a, int b, int c) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        if (a > 0) pq.add(a);
        if (b > 0) pq.add(b);
        if (c > 0) pq.add(c);
        while (pq.size() >= 2) {
            int i = pq.poll(), j = pq.poll();
            count++;
            if (i > 1) pq.add(i - 1);
            if (j > 1) pq.add(j - 1);
        }
        return count;
    }

    public static int maximumScore_dp(int a, int b, int c) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(new int[]{a, b, c}, memo);
    }

    private static int helper(int[] nums, Map<String, Integer> memo) {
        Arrays.sort(nums);
        if (nums[0] == 0 && nums[1] == 0) return 0;
        String key = Arrays.toString(nums);
        if (memo.containsKey(key)) return memo.get(key);
        if (nums[0] + nums[1] <= nums[2]) return Math.min(nums[0] + nums[1], nums[2]);
        System.out.println("nums = " + Arrays.toString(nums));
        int count = 0;
//        At each step there are two possibilities. Take from (0,1), (1,2), (2,0)
        if (nums[0] > 0 && nums[1] > 0) {
            nums[0]--;
            nums[1]--;
            int next = helper(nums, memo);
            count = Math.max(count, next + 1);
            nums[0]++;
            nums[1]++;
        }
        if (nums[1] > 0 && nums[2] > 0) {
            nums[1]--;
            nums[2]--;
            int next = helper(nums, memo);
            count = Math.max(count, next + 1);
            nums[1]++;
            nums[2]++;
        }
        if (nums[2] > 0 && nums[0] > 0) {
            nums[0]--;
            nums[2]--;
            int next = helper(nums, memo);
            count = Math.max(count, next + 1);
            nums[0]++;
            nums[2]++;
        }
        memo.put(key, count);
        return count;
    }

    public int maximumScore_wrong(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        int v1 = Math.min(nums[0], nums[2]);
        int v2 = Math.min(nums[2] - v1, nums[1]);
        return v1 + v2;
    }
}
