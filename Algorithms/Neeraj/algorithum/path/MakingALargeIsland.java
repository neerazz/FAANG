import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Sep 30, 2021
 * Ref: https://leetcode.com/problems/making-a-large-island/
 */
public class MakingALargeIsland {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1, 0}, {0, 1}}) + " = 3");
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] islands = new int[n][n];
        int max = 0, count = 1;
        int[] counts = new int[n * n + 2];
        List<int[]> zeros = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (islands[r][c] == 0 && grid[r][c] == 1) {
                    dfs(grid, islands, count, r, c, n, counts);
                    max = Math.max(max, counts[count]);
                    count++;
                }
                if (grid[r][c] == 0) {
                    zeros.add(new int[]{r, c});
                }
            }
        }
        for (int[] idx : zeros) {
            Set<Integer> others = new HashSet<>();
            for (int[] dir : dirs) {
                int nr = idx[0] + dir[0], nc = idx[1] + dir[1];
                if (inRange(nr, nc, n) && islands[nr][nc] > 0) {
                    others.add(islands[nr][nc]);
                }
            }
            int cur = 1;
            for (int id : others) {
                cur += counts[id];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    static void dfs(int[][] grid, int[][] islands, int id, int r, int c, int n, int[] counts) {
        islands[r][c] = id;
        counts[id]++;
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (inRange(nr, nc, n) && grid[nr][nc] == 1 && islands[nr][nc] == 0) {
                dfs(grid, islands, id, nr, nc, n, counts);
            }
        }
    }

    static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
