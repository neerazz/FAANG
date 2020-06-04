package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class SearchRowColSortedMatrix {

    @EpiTest(testDataFile = "search_row_col_sorted_matrix.tsv")
    public static boolean matrixSearch(List<List<Integer>> A, int x) {
        int rows = A.size(), cols = rows > 0 ? A.get(0).size() : 0;
        if (cols == 0) return false;
        int row = 0, col = cols - 1;
        while (col >= 0 && row < rows) {
            if (A.get(row).get(col) == x) {
                return true;
            } else if (A.get(row).get(col) < x) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SearchRowColSortedMatrix.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
