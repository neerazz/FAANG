package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixEnclosedRegions {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

/*    public static void fillSurroundedRegions(List<List<Character>> board) {
        // TODO - you fill in here.
        //Let A be a 2D array whose entries are either WorB. Write a program that takes A, and replaces all Ws that cannot reach the boundary with a B.
        //DO DFS -
        //1. Replace all W's with B
        //2. If W is at end -> Backtrack and undo. Change to W
        dfs(board, 0, 0);
    }

    public static boolean dfs(List<List<Character>> board, int x, int y) {
        if (x < 0 || x > board.size() || y < 0 || y > board.get(x).size() || board.get(x).get(y) == 'B') return true;
        if ((x == 0 || y == 0 || x == board.size() - 1 || y == board.get(x).size() - 1) && board.get(x).get(y) == 'W')
            return false;

        board.get(x).set(y, 'B');

        boolean status = false;

        for (int[] dir : dirs) {
            if (dfs(board, x + dir[0], y + dir[1])) {
                status = true;
            }
        }

        if (!status) {
            board.get(x).set(y, 'W');
            return false;
        }
        return true;
    }*/

    public static void fillSurroundedRegions(List<List<Character>> board) {
        int rows = board.size(), cols = rows > 0 ? board.get(0).size() : 0;
        Set<Integer> visited = new HashSet<>();
//        Add all the trace of 'W' connected to the boundaries
        for (int row = 0; row < rows; row++) {
//            Check the first and last column that has 'W' in it.
            if (board.get(row).get(0) == 'W') {
                dfs(row, 0, rows, cols, visited, board);
            }
            if (board.get(row).get(cols - 1) == 'W') {
                dfs(row, cols - 1, rows, cols, visited, board);
            }
        }
        for (int col = 0; col < cols; col++) {
//            Check the first and last row that has 'W' in it.
            if (board.get(0).get(col) == 'W') {
                dfs(0, col, rows, cols, visited, board);
            }
            if (board.get(rows - 1).get(col) == 'W') {
                dfs(rows - 1, col, rows, cols, visited, board);
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
        visited.add(rows * 10000 + col);
        for (int[] dir : dirs) {
            dfs(row + dir[0], col + dir[1], rows, cols, visited, board);
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
