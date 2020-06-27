package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class MaxTrappedWater {
    @EpiTest(testDataFile = "max_trapped_water.tsv")
    public static int getMaxTrappedWater(List<Integer> heights) {
        int op = 0, p1 = 0, p2 = heights.size() - 1;
        while (p1 < p2) {
            int p1v = heights.get(p1), p2v = heights.get(p2);
            op = Math.max(op, Math.min(p1v, p2v) * (p2 - p1));
            if (p1v > p2v) {
                p2--;
            } else {
                p1++;
            }
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "MaxTrappedWater.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
