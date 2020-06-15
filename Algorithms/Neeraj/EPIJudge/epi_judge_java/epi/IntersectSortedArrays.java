package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectSortedArrays {
    @EpiTest(testDataFile = "intersect_sorted_arrays.tsv")

    public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                         List<Integer> B) {
        Set<Integer> op = new LinkedHashSet<>();
        int p1 = 0, p2 = 0, p1L = A.size(), p2L = B.size();
        while (p1 < p1L && p2 < p2L) {
            if (A.get(p1).equals(B.get(p2))) {
                op.add(A.get(p1));
                p1++;
                p2++;
            } else if (A.get(p1) < B.get(p2)) {
                p1++;
            } else {
                p2++;
            }
        }
        return new ArrayList<>(op);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IntersectSortedArrays.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
