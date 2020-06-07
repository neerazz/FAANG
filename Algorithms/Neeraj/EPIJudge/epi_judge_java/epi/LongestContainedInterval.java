package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestContainedInterval {

    @EpiTest(testDataFile = "longest_contained_interval.tsv")
    public static int longestContainedRange(List<Integer> A) {
        if (A.size() <= 1) return A.size();
        List<Integer> sorted = A.stream().distinct().sorted().collect(Collectors.toList());
        int p1 = 0, p2 = 1, op = 0;
        while (p2 < sorted.size()) {
            if (sorted.get(p2 - 1) + 1 != sorted.get(p2)) {
                op = Math.max(op, p2 - p1);
                p1 = p2;
            }
            p2++;
        }
        return Math.max(op, p2 - p1);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LongestContainedInterval.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
