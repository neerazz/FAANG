package ds.queueAndStack;

import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

 */
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Arrays.stream(floodFill(image, 1, 1, 2)).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int columns = rows > 0 ? image[0].length : 0;
        int startColourValue = image[sr][sc];
        HashSet<Integer> visited = new HashSet<>();
        return floodFillHelper(image, sr, sc, rows, columns, startColourValue, newColor, visited);
    }

    private static int[][] floodFillHelper(int[][] image, int currentRow, int currentColumn, int rows, int columns, int startColourValue, int newColor, HashSet<Integer> visited) {
        if (currentRow < 0 || currentRow >= rows || currentColumn < 0 || currentColumn >= columns ||
                visited.contains(currentRow + currentColumn * columns) || image[currentRow][currentColumn] != startColourValue) {
            return image;
        }
//        Change the current value and add it to the visited hashset and go through all the 4 directions.
        image[currentRow][currentColumn] = newColor;
        visited.add(currentRow + currentColumn * columns);
        int[][] ints = floodFillHelper(image, currentRow + 1, currentColumn, rows, columns, startColourValue, newColor, visited);
        int[][] ints1 = floodFillHelper(ints, currentRow - 1, currentColumn, rows, columns, startColourValue, newColor, visited);
        int[][] ints2 = floodFillHelper(ints1, currentRow, currentColumn - 1, rows, columns, startColourValue, newColor, visited);
        return floodFillHelper(ints2, currentRow, currentColumn + 1, rows, columns, startColourValue, newColor, visited);
    }
}
