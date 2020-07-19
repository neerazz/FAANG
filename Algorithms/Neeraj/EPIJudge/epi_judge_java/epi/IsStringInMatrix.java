package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class IsStringInMatrix {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @EpiTest(testDataFile = "is_string_in_matrix.tsv")
    public static boolean isPatternContainedInGrid(List<List<Integer>> grid,
                                                   List<Integer> pattern) {
        int rows = grid.size(), cols = rows > 0 ? grid.get(0).size() : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid.get(row).get(col).equals(pattern.get(0)) && isPossible(grid, pattern, row, col, 0, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPossible(List<List<Integer>> grid, List<Integer> pattern, int row, int col, int i, int rows, int cols) {
        if (!canTravel(grid, pattern, i, row, col, rows, cols)) return false;
        if (pattern.size() - 1 == i) return true;
        for (int[] dir : dirs) {
            if (isPossible(grid, pattern, row + dir[0], col + dir[1], i + 1, rows, cols)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canTravel(List<List<Integer>> grid, List<Integer> pattern, Integer idx, int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols && pattern.size() > idx && grid.get(row).get(col).equals(pattern.get(idx));
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsStringInMatrix.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
