package leetcode.v1.medium;

import java.util.TreeMap;

public class FindInSorted2dArray {
    public boolean searchMatrix(int[][] matrix, int target) {

        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < matrix.length; i++) {
            tree.put(matrix[i][0], i);
        }
        int val = tree.floorKey(target);
        if (val == target) return true;

        int r = tree.get(val);
        tree = new TreeMap<>();
        for (int j = 0; j < matrix[0].length; j++) {
            tree.put(matrix[r][j], j);
        }
        val = tree.floorKey(target);
        return val == target;
    }
}
