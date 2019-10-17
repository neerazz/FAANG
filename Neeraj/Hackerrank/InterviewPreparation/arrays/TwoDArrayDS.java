package InterviewPreparation.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://www.hackerrank.com/challenges/2d-array
Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output
19
 */
public class TwoDArrayDS {
    public static void main(String[] args) {
        System.out.println(hourglassSum(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        }) + " should be [7].");
        System.out.println(hourglassSum(new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        }) + " should be [28].");
        System.out.println(hourglassSum(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0},
        }) + " should be [19].");
    }

    static int hourglassSum(int[][] arr) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            integers.add(getHourGlassSum(arr, i, 2 + i, 0, 2));
            integers.add(getHourGlassSum(arr, i, 2 + i, 1, 3));
            integers.add(getHourGlassSum(arr, i, 2 + i, 2, 4));
            integers.add(getHourGlassSum(arr, i, 2 + i, 3, 5));
        }
        return integers.stream().mapToInt(i -> i).max().orElse(-1);
    }

    private static int getHourGlassSum(int[][] arr, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        int sum = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            int rowMid = rowStart + 1;
            if (i != rowMid) {
                for (int j = columnStart; j <= columnEnd; j++) {
                    sum += arr[i][j];
                }
            } else {
                int columnMid = columnStart + 1;
                sum += arr[rowMid][columnMid];
            }
        }
        return sum;
    }
}
