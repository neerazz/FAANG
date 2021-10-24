import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 12, 2021
 * Ref:https://www.codingninjas.com/codestudio/problems/sub-matrices-with-sum-zero_1102321?topList=top-google-coding-interview-questions
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class SubMatricesWithSumZero {

    public static void main(String[] args) {
        System.out.println(subMatrices(new int[][]{{}}, 2) + " = 5");
    }

    public static int subMatrices(int[][] mat, int target) {
//        Calculate the prefix sum
        int rows = mat.length, cols = mat[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                mat[row][col] += mat[row][col - 1];
            }
        }
        int result = 0;
        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = c1; c2 < cols; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int r = 0; r < rows; r++) {
//                    You are looking for sum only from c1, to c2 col in r row.
                    sum += mat[r][c2] - (c1 > 0 ? mat[r][c1 - 1] : 0);
                    result += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return result;
    }

    public static int subMatrices(ArrayList<ArrayList<Integer>> mat, int n) {
        int[][] nums = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                nums[r][c] = mat.get(r).get(c);
            }
        }
        return subMatrices(nums, 0);
    }
}
