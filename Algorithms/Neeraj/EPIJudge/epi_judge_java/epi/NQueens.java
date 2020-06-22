package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.*;
import java.util.function.BiPredicate;

public class NQueens {

    static List<List<Integer>> result;

    @EpiTest(testDataFile = "n_queens.tsv")
    public static List<List<Integer>> nQueens(int n) {
        result = new ArrayList<>();
        boolean[] rows = new boolean[n], cols = new boolean[n], dia1 = new boolean[2 * n], dia2 = new boolean[2 * n];
        helper(n, 0, rows, cols, dia1, dia2, new LinkedList<>());
        return result;
    }

    private static void helper(int n, int row, boolean[] rows, boolean[] cols, boolean[] dia1, boolean[] dia2, LinkedList<Integer> soFar) {
        if (row > n) return;
        if (row == n) {
            result.add(new ArrayList<>(soFar));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!rows[row] && !cols[i] && !dia1[row + i] && !dia2[i - row + n]) {
                soFar.addLast(i);
                rows[row] = cols[i] = dia1[row + i] = dia2[i - row + n] = true;
                helper(n, row + 1, rows, cols, dia1, dia2, soFar);
                rows[row] = cols[i] = dia1[row + i] = dia2[i - row + n] = false;
                soFar.removeLast();
            }
        }
    }


    @EpiTestComparator
    public static boolean comp(List<List<Integer>> expected,
                               List<List<Integer>> result) {
        if (result == null) {
            return false;
        }
        expected.sort(new LexicographicalListComparator<>());
        result.sort(new LexicographicalListComparator<>());
        return expected.equals(result);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "NQueens.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
