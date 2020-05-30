package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIncreasingDecreasingArray {
    @EpiTest(testDataFile = "sort_increasing_decreasing_array.tsv")

    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        Collections.sort(A);
        return A;
    }

    private static List<Integer> mergeSortedList(List<Integer> l1, List<Integer> l2) {
        List<Integer> op = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            if (l1.get(p1) < l2.get(p2)) {
                op.add(l1.get(p1++));
            } else {
                op.add(l2.get(p2++));
            }
        }
        while (p1 < l1.size()) op.add(l1.get(p1++));
        while (p2 < l2.size()) op.add(l2.get(p2++));
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortIncreasingDecreasingArray.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
