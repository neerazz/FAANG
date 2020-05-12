package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsValidSudoku {
    @EpiTest(testDataFile = "is_valid_sudoku.tsv")

    // Check if a partially filled matrix has any conflicts.
    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
        Set[] row = new HashSet[9], col = new HashSet[9], inner = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            inner[i] = new HashSet<>();
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int cur = partialAssignment.get(r).get(c), in = getInner(r, c);
                if ((!row[r].add(cur) || !col[c].add(cur) || !inner[in].add(cur)) && cur != 0) return false;
            }
        }
        return true;
    }

    private static int getInner(int i, int j) {
        if (i >= 0 && i <= 2 && j >= 0 && j <= 2) return 0;
        if (i >= 3 && i <= 5 && j >= 0 && j <= 2) return 1;
        if (i >= 6 && i <= 8 && j >= 0 && j <= 2) return 2;
        if (i >= 0 && i <= 2 && j >= 3 && j <= 5) return 3;
        if (i >= 3 && i <= 5 && j >= 3 && j <= 5) return 4;
        if (i >= 6 && i <= 8 && j >= 3 && j <= 5) return 5;
        if (i >= 0 && i <= 2 && j >= 6 && j <= 8) return 6;
        if (i >= 3 && i <= 5 && j >= 6 && j <= 8) return 7;
        else return 8;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsValidSudoku.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
