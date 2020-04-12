package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixEnclosedRegions {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void fillSurroundedRegions(List<List<Character>> board) {
        int rows = board.size(), cols = rows > 0 ? board.get(0).size() : 0;
        Set<Integer> visited = new HashSet<>();
//        Add all the trace of 'W' connected to the boundaries
        for (int row = 0; row < rows; row++) {
//            Check the first and last column that has 'W' in it.
            int col = 0;
            if (board.get(row).get(col) == 'W') {
                dfs(row, col, rows, cols, visited, board);
            }
            col = cols - 1;
            if (board.get(row).get(col) == 'W') {
                dfs(row, col, rows, cols, visited, board);
            }
        }
        for (int col = 0; col < cols; col++) {
//            Check the first and last row that has 'W' in it.
            int row = 0;
            if (board.get(row).get(col) == 'W') {
                dfs(row, col, rows, cols, visited, board);
            }
            row = rows - 1;
            if (board.get(row).get(col) == 'W') {
                dfs(row, col, rows, cols, visited, board);
            }
        }
        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                if (board.get(row).get(col) == 'W' && !visited.contains(row * 10000 + col)) {
                    board.get(row).set(col, 'B');
                }
            }
        }
    }

    private static void dfs(int row, int col, int rows, int cols, Set<Integer> visited, List<List<Character>> board) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board.get(row).get(col) == 'B' || visited.contains(row * 10000 + col)) {
            return;
        }
        visited.add(row * 10000 + col);
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (!visited.contains(newRow * 10000 + newCol)) {
                dfs(newRow, newCol, rows, cols, visited, board);
            }
        }
    }

    @EpiTest(testDataFile = "matrix_enclosed_regions.tsv")
    public static List<List<Character>>
    fillSurroundedRegionsWrapper(List<List<Character>> board) {
        fillSurroundedRegions(board);
        return board;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "MatrixEnclosedRegions.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
