import java.util.PriorityQueue;

/**
 * Created on:  Jan 18, 2021
 * Questions: https://aonecode.com/path-with-maximum-minimum-value-1
 * https://leetcode.com/discuss/interview-question/383669/
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 */

public class MaximalMinimumValuePathI {

    public static void main(String[] args) {
        System.out.println(maxPathScore(new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}}) + " = 0");
        System.out.println(maxPathScore(new int[][]{{13, 4, 6, 3, 4}, {0, 2, 1, 1, 6}, {9, 9, -3, 2, 6}, {3, 2, 4, 19, 18}, {14, 1, 2, 0, 0}, {14, 16, 25, 24, -3}}) + " = -3");
    }

    public static int maxPathScore(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] directions = {{1, 0}, {0, 1}};
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> Integer.compare(v2[2], v1[2]));
//            0: row, 1: col, 2: min val
        queue.add(new int[]{0, 0, matrix[0][0]});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == rows - 1 && poll[1] == cols - 1) {
                return poll[2];
            }
            for (int[] dir : directions) {
                int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;
//                    if (nr == rows - 1 && nc == cols - 1) soFarMin = poll[2];
                queue.add(new int[]{nr, nc, Math.min(matrix[nr][nc], poll[2])});
                visited[nr][nc] = true;
            }
        }
        return max;
    }
}
