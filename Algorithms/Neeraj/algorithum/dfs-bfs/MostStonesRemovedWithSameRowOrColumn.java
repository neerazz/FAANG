import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Sep 23, 2021
 * Ref: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {

    }

    public static int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int count = 0, len = stones.length;
        for (int[] stone : stones) {
            if (visited.contains(stone)) continue;
            count++;
            dfs(stone, stones, visited);
        }
        return len - count;
    }

    static void dfs(int[] stone, int[][] stones, Set<int[]> visited) {
        visited.add(stone);
        for (int[] cur : stones) {
            if (!visited.contains(cur) && (cur[0] == stone[0] || cur[1] == stone[1])) {
                dfs(cur, stones, visited);
            }
        }
    }
}
