package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrdering {
    @EpiTest(testDataFile = "spiral_ordering.tsv")

    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        int sr = 0, sc = 0, er = squareMatrix.size(), ec = er > 0 ? squareMatrix.get(0).size() : 0;
        List<Integer> op = new ArrayList<>();
        while (sr < er && sc < ec) {
//            Loop through the top row.
            for (int i = sc; i < ec; i++) {
                op.add(squareMatrix.get(sr).get(i));
            }
            sr++;

//            Then travel through the right column.
            for (int i = sr; i < er; i++) {
                op.add(squareMatrix.get(i).get(ec - 1));
            }
            ec--;

//            Traverse through the bottom row.
            if (sr < er) {
                for (int i = ec - 1; i >= sc; i--) {
                    op.add(squareMatrix.get(er - 1).get(i));
                }
                er--;
            }

//            Traverse through the left columns
            if (sc < ec) {
                for (int i = er - 1; i >= sr; i--) {
                    op.add(squareMatrix.get(i).get(sc));
                }
                sc++;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SpiralOrdering.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
