package level1;

import java.util.Arrays;

/*
You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its horizontal axis.
Example:
Input image :
              1 1
              0 0
Modified to :
              0 0
              1 1
 */
public class HorizontalFlip {
    public static void main(String[] args) {
        int[][] image = {{1, 1}, {0, 0}};
        flipHorizontalAxis(image);
        Arrays.stream(image).forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("===================================================");
        image = new int[][]{{1, 2, 3}, {2, 3, 4}, {0, 0, 0}};
        flipHorizontalAxis(image);
        Arrays.stream(image).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public static void flipHorizontalAxis(int[][] matrix) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int[] firstArray = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = firstArray;
            start++;
            end--;
        }
    }
}
