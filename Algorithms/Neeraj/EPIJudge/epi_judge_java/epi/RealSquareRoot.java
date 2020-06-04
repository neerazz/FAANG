package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class RealSquareRoot {
    @EpiTest(testDataFile = "real_square_root.tsv")

    public static double squareRoot(double x) {
        if (x == 1) return 1;
        double start = 1, end = x;
        if (x < 1) {
            start = 0;
            end = 1;
        }
        while (start < end) {
            double mid = start + (end - start) / 2;
            double midV = mid * mid;
            if (Math.abs(midV - x) < 0.000001) {
                return mid;
            } else if (midV > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "RealSquareRoot.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
