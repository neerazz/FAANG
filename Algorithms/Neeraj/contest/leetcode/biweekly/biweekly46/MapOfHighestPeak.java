package biweekly.biweekly46;

import java.util.*;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class MapOfHighestPeak {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0, 1}, {0, 0}})));
//        System.out.println(Arrays.deepToString(highestPeak(new int[][]{{0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0}})));
        System.out.println(Arrays.deepToString(highestPeak_rev2(new int[][]{{0, 1}, {0, 0}})));
//        System.out.println(Arrays.deepToString(highestPeak_rev2(new int[][]{{0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0, 0}})));
    }

    //    Start with all the water and keep incrementing the values by checking the surroundings.
    public static int[][] highestPeak_rev2(int[][] isWater) {
        int rows = isWater.length, cols = rows > 0 ? isWater[0].length : 0;
        int[][] height = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isWater[row][col] == 1) queue.add(new int[]{row, col});
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                if (inBoundary(nr, nc, rows, cols) && isWater[nr][nc] == 0) {
//                    Mark the current row as water so that it is not visited again.
                    isWater[nr][nc] = 1;
                    height[nr][nc] = height[poll[0]][poll[1]] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return height;
    }

    private static boolean inBoundary(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    //    Start with all the land and keep incrementing the values by checking the surroundings.
    public static int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length, cols = rows > 0 ? isWater[0].length : 0;
        int[][] height = new int[rows][cols];
//        If water set to -1, if visited set to -2.
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> Integer.compare(v2[2], v1[2]));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isWater[row][col] == 0) {
                    queue.add(new int[]{row, col, height[row][col] = 1});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<int[]> increased = new ArrayList<>();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int row = poll[0], col = poll[1], cur = poll[2];
                if (height[row][col] > cur) continue;
                int min = Integer.MAX_VALUE;
                for (int[] dir : dirs) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (inBoundary(nr, nc, rows, cols)) {
                        min = Math.min(min, height[nr][nc]);
                    }
                }
                if (min + 1 > height[row][col]) {
                    increased.add(new int[]{row, col});
                }
            }
            for (int[] inc : increased) {
                queue.add(new int[]{inc[0], inc[1], ++height[inc[0]][inc[1]]});
            }
        }
        return height;
    }

}
