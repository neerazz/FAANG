import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3711/
 */

public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {

    }

    public int minOperations(int[] nums) {
        int pre = nums[0], len = nums.length, oper = 0;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur <= pre) {
                int diff = pre - cur + 1;
                oper += diff;
                cur += diff;
            }
            pre = cur;
        }
        return oper;
    }

    public int numSubmatrixSumTarget(int[][] A, int target) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                A[i][j] += A[i][j - 1];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
