package biweekly27;

import java.util.*;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/cherry-pickup-ii/
 */
public class CherryPickupII {
    public static void main(String[] args) {
        System.out.println("*************************** Method 1 ********************************");
        System.out.println(cherryPickup(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}) + "\t should be [24]");
        System.out.println(cherryPickup(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}) + "\t should be [28]");
        System.out.println(cherryPickup(new int[][]{{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}) + "\t should be [22]");
        System.out.println(cherryPickup(new int[][]{{1, 1}, {1, 1}}) + "\t should be [4]");

        System.out.println("*************************** Method 1 ********************************");
        System.out.println(cherryPickup_optimal(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}) + "\t should be [24]");
        System.out.println(cherryPickup_optimal(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}) + "\t should be [28]");
        System.out.println(cherryPickup_optimal(new int[][]{{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}) + "\t should be [22]");
        System.out.println(cherryPickup_optimal(new int[][]{{1, 1}, {1, 1}}) + "\t should be [4]");
    }

    private static int cherryPickup_optimal(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int op = 0;
        if (cols == 0) return op;
        Map<String, Integer> map = new HashMap<>();
        return dfs(map, 0, 0, 0, cols - 1, rows, cols, grid);
    }

    static int[] dirs = {-1, 0, 1};

    private static int dfs(Map<String, Integer> map, int r1r, int r1c, int r2r, int r2c, int rows, int cols, int[][] grid) {
//        When out of boundary then return 0;
        if (!inRange(r1r, r1c, rows, cols) || !inRange(r2r, r2c, rows, cols)) return 0;
        String val1 = r1r + "-" + r1c + "-" + r2r + "-" + r2c;
        String val2 = r2r + "-" + r2c + "-" + r1r + "-" + r1c;

        if (map.containsKey(val1)) return map.get(val1);
        if (map.containsKey(val2)) return map.get(val2);

        int sum = grid[r1r][r1c] + grid[r2r][r2c];
        if (r1r == r2r && r1c == r2c) sum -= grid[r2r][r2c];
        int max = 0;
        for (int dir1 : dirs) {
            for (int dir2 : dirs) {
                int next = dfs(map, r1r + 1, r1c + dir1, r2r + 1, r2c + dir2, rows, cols, grid);
                max = Math.max(max, next);
            }
        }

//        Add both the strings into map
        map.put(val1, sum + max);
        map.put(val2, sum + max);
        return sum + max;
    }

    public static int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int op = 0;
        if (cols == 0) return op;
        Queue<CurrentPositions> queue = new LinkedList<>();
        int r1r = 0, r1c = 0, r2r = 0, r2c = cols - 1;
        queue.add(new CurrentPositions(new int[]{r1r, r1c}, new int[]{r2r, r2c}, grid[r1r][r1c] + grid[r2r][r2c]));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<CurrentPositions> visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                CurrentPositions poll = queue.poll();
                op = Math.max(op, poll.collected);
                if (!poll.bothAtSamePosition()) {
                    for (int dir : dirs) {
                        int r1rN = poll.rob1[0] + 1, r1cN = poll.rob1[1] + dir;
                        if (inRange(r1rN, r1cN, rows, cols)) {
                            for (int dir2 : dirs) {
                                int r2rN = poll.rob2[0] + 1, r2cN = poll.rob2[1] + dir2;
                                if (inRange(r2rN, r2cN, rows, cols)) {
                                    CurrentPositions next = new CurrentPositions(new int[]{r1rN, r1cN}, new int[]{r2rN, r2cN}, poll.collected + grid[r1rN][r1cN] + grid[r2rN][r2cN]);
                                    if (!visited.contains(next)) {
                                        queue.add(next);
                                        visited.add(next);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
//        return dfs(new int[]{0, 0}, new int[]{0, cols - 1}, rows, cols, grid, visited, 0);
        return op;
    }

    private static int getHash(int[] indxs) {
        return getHash(indxs[0], indxs[1]);
    }

    private static boolean inRange(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static int getHash(int row, int col) {
        return row * 1000 + col;
    }

    static class CurrentPositions {
        int[] rob1;
        int[] rob2;
        int collected;

        public CurrentPositions(int[] rob1, int[] rob2, int collected) {
            this.rob1 = rob1;
            this.rob2 = rob2;
            this.collected = collected;
        }

        boolean bothAtSamePosition() {
            return rob1[0] == rob2[0] && rob1[1] == rob2[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CurrentPositions that = (CurrentPositions) o;

            if (!Arrays.equals(rob1, that.rob1)) return false;
            return Arrays.equals(rob2, that.rob2);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(rob1);
            result = 31 * result + Arrays.hashCode(rob2);
            return result;
        }

        @Override
        public String toString() {
            return "CurrentPositions{" +
                    "rob1=" + Arrays.toString(rob1) +
                    ", rob2=" + Arrays.toString(rob2) +
                    ", collected=" + collected +
                    '}';
        }
    }
}
