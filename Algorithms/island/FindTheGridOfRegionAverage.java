import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 06, 2024
 * Ref: https://leetcode.com/problems/find-the-grid-of-region-average/description/
 */

public class FindTheGridOfRegionAverage {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(resultGrid(new int[][]{{5, 6, 7, 10}, {8, 9, 10, 10}, {11, 12, 13, 10}}, 3)));
        System.out.println(Arrays.deepToString(resultGrid(new int[][]{{0, 14, 5, 15}, {20, 12, 2, 11}, {8, 11, 0, 3}}, 14)));
        System.out.println(Arrays.deepToString(resultGrid(new int[][]{{1, 1, 4, 1}, {10, 8, 13, 17}, {2, 12, 1, 16}}, 14)));
        System.out.println(Arrays.deepToString(resultGrid(new int[][]{{1, 18, 6, 4}, {4, 5, 17, 12}, {10, 1, 15, 19}}, 14)));
    }

    public static int[][] resultGrid(int[][] image, int threshold) {
        int rows = image.length, cols = rows > 0 ? image[0].length : 0;
        int[][] result = new int[rows][cols];
        int[] dirs = {0, 1, 2};
        int[][] counts = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
//                Check if Region is valid or not.
                int xMax = Math.min(rows, row + 3), yMax = Math.min(col + 3, cols);
                int count = 0;
                int sum = 0;
                boolean isPossible = true;
                checkRegion:
                for (int dir1 : dirs) {
                    for (int dir2 : dirs) {
                        int x = row + dir1, y = col + dir2;
                        if (inRange(x, y, 0, 0, rows, cols)) {
                            if (!validNeighbours(x, y, row, col, xMax, yMax, image, threshold)) {
                                isPossible = false;
                                break checkRegion;
                            } else {
                                count++;
                                sum += image[x][y];
                            }
                        }
                    }
                }
                isPossible = isPossible && count == 9;
//                If valid Loop through the region and set that its valid.
                if (isPossible) {
                    int curAvg = sum / 9;
                    for (int dir1 : dirs) {
                        for (int dir2 : dirs) {
                            int x = row + dir1, y = col + dir2;
                            if (inRange(x, y, 0, 0, rows, cols)) {
                                result[x][y] += curAvg;
                                counts[x][y]++;
                            }
                        }
                    }
                }
            }
        }
//        System.out.println("result = " + Arrays.deepToString(result));

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = counts[row][col];
                if(count == 0){
                    result[row][col] = image[row][col];
                }else{
                    result[row][col] /= count;
                }
            }
        }

//        System.out.println("result = " + Arrays.deepToString(result));
        return result;
    }

    private static boolean inRange(int row, int col, int xStart, int yStart, int xEnd, int yEnd) {
        return row >= xStart && row < xEnd && col >= yStart && col < yEnd;
    }

    private static boolean validNeighbours(int row, int col, int xStart, int yStart, int xEnd, int yEnd, int[][] image, int threshold) {
        int[] up = new int[]{row - 1, col};
        int[] left = new int[]{row, col - 1};
        int[] down = new int[]{row + 1, col};
        int[] right = new int[]{row, col + 1};
        int curNum = image[row][col];
        for (int[] ids : List.of(up, left, right, down)) {
            int x = ids[0], y = ids[1];
            if (inRange(x, y, xStart, yStart, xEnd, yEnd) && Math.abs(curNum - image[x][y]) > threshold) {
                return false;
            }
        }
        return true;
    }

}
