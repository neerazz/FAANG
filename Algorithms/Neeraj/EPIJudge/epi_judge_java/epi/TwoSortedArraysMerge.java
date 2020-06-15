package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSortedArraysMerge {

    public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                            List<Integer> B, int n) {
        List<Integer> temp = new ArrayList<>(A.subList(0, m));
        A.clear();
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (temp.get(p1) <= B.get(p2)) {
                A.add(temp.get(p1++));
            } else {
                A.add(B.get(p2++));
            }
        }
        A.addAll(temp.subList(p1, m));
        A.addAll(B.subList(p2, n));
    }

    @EpiTest(testDataFile = "two_sorted_arrays_merge.tsv")
    public static List<Integer>
    mergeTwoSortedArraysWrapper(List<Integer> A, int m, List<Integer> B, int n) {
        mergeTwoSortedArrays(A, m, B, n);
        return A;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "TwoSortedArraysMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
