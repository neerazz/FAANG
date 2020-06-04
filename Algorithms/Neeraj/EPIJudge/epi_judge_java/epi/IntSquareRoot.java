package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IntSquareRoot {
    @EpiTest(testDataFile = "int_square_root.tsv")
    public static int squareRoot(int k) {
        if (k <= 1) return k;
        long start = 0, end = k / 2;
        while (start+1 < end) {
            long mid = start + (end - start) / 2;
            if ((mid * mid) == k) {
                return (int) mid;
            } else if ((mid * mid) < k) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (end * end <= k) return (int) end;
        if (start * start <= k) return (int) start;
        return -1;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IntSquareRoot.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
