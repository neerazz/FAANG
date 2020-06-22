package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ABSqrt2 {

    @EpiTest(testDataFile = "a_b_sqrt2.tsv")
    public static List<Double> generateFirstKABSqrt2(int k) {
        SortedSet<int[]> set = new TreeSet<>((i1, i2) -> Double.compare(getABSqrt2(i1), getABSqrt2(i2)));
        set.add(new int[]{0, 0});
        List<Double> op = new ArrayList<>();
        while (op.size() < k) {
            int[] first = set.first();
            op.add(getABSqrt2(first));
            set.add(new int[]{first[0] + 1, first[1]});
            set.add(new int[]{first[0], first[1] + 1});
            set.remove(first);
        }
        return op;
    }

    private static double getABSqrt2(int[] val) {
        return val[0] + (val[1] * Math.sqrt(2));
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ABSqrt2.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
