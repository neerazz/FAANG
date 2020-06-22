package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SudokuSolve {

    public static boolean solveSudoku(List<List<Integer>> partialAssignment) {
        boolean[][] rows = new boolean[9][10], cols = new boolean[9][10], inner = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Integer cur = partialAssignment.get(i).get(j);
                if (cur != 0) {
                    rows[i][cur] = cols[j][cur] = inner[getInner(i, j)][cur] = true;
                }
            }
        }
        return sodokuHelper(partialAssignment, 0, 0, rows, cols, inner);
    }

    private static boolean sodokuHelper(List<List<Integer>> board, int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] inner) {
        if (row == 8 && col == 9) return true;
        if (col == 9) {
            row++;
            col = 0;
        }
        Integer cur = board.get(row).get(col);
        if (cur == 0) {
            for (int i = 1; i < 10; i++) {
                if (!rows[row][i] && !cols[col][i] && !inner[getInner(row, col)][i]) {
                    rows[row][i] = cols[col][i] = inner[getInner(row, col)][i] = true;
                    board.get(row).set(col, i);
                    if (sodokuHelper(board, row, col + 1, rows, cols, inner)) {
                        return true;
                    }
                    board.get(row).set(col, 0);
                    rows[row][i] = cols[col][i] = inner[getInner(row, col)][i] = false;
                }
            }
            return false;
        }
        return sodokuHelper(board, row, col + 1, rows, cols, inner);
    }

    private static int getInner(int i, int j) {
        return (3 * (i / 3)) + j / 3;
    }

    @EpiTest(testDataFile = "sudoku_solve.tsv")
    public static void solveSudokuWrapper(TimedExecutor executor,
                                          List<List<Integer>> partialAssignment)
            throws Exception {
        List<List<Integer>> solved = new ArrayList<>();
        for (List<Integer> row : partialAssignment) {
            solved.add(new ArrayList<>(row));
        }

        executor.run(() -> solveSudoku(solved));

        if (partialAssignment.size() != solved.size()) {
            throw new TestFailure("Initial cell assignment has been changed");
        }

        for (int i = 0; i < partialAssignment.size(); i++) {
            List<Integer> br = partialAssignment.get(i);
            List<Integer> sr = solved.get(i);
            if (br.size() != sr.size()) {
                throw new TestFailure("Initial cell assignment has been changed");
            }
            for (int j = 0; j < br.size(); j++)
                if (br.get(j) != 0 && !Objects.equals(br.get(j), sr.get(j)))
                    throw new TestFailure("Initial cell assignment has been changed");
        }

        int blockSize = (int) Math.sqrt(solved.size());
        for (int i = 0; i < solved.size(); i++) {
            assertUniqueSeq(solved.get(i));
            assertUniqueSeq(gatherColumn(solved, i));
            assertUniqueSeq(gatherSquareBlock(solved, blockSize, i));
        }
    }

    private static void assertUniqueSeq(List<Integer> seq) throws TestFailure {
        Set<Integer> seen = new HashSet<>();
        for (Integer x : seq) {
            if (x == 0) {
                throw new TestFailure("Cell left uninitialized");
            }
            if (x < 0 || x > seq.size()) {
                throw new TestFailure("Cell value out of range");
            }
            if (seen.contains(x)) {
                throw new TestFailure("Duplicate value in section");
            }
            seen.add(x);
        }
    }

    private static List<Integer> gatherColumn(List<List<Integer>> data, int i) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> row : data) {
            result.add(row.get(i));
        }
        return result;
    }

    private static List<Integer> gatherSquareBlock(List<List<Integer>> data,
                                                   int blockSize, int n) {
        List<Integer> result = new ArrayList<>();
        int blockX = n % blockSize;
        int blockY = n / blockSize;
        for (int i = blockX * blockSize; i < (blockX + 1) * blockSize; i++) {
            for (int j = blockY * blockSize; j < (blockY + 1) * blockSize; j++) {
                result.add(data.get(i).get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SudokuSolve.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
