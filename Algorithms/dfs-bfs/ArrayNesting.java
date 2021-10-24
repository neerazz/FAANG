/**
 * Created on:  Sep 01, 2021
 * Ref: https://leetcode.com/problems/array-nesting/
 */
public class ArrayNesting {
    public static void main(String[] args) {

    }

    public static int arrayNesting(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            int cur = dfs(i, nums, visited);
            max = Math.max(max, cur);
        }
        return max;
    }

    static int dfs(int cur, int[] nums, boolean[] visited) {
        if (visited[cur]) return 0;
        visited[cur] = true;
        return 1 + dfs(nums[cur], nums, visited);
    }
}
