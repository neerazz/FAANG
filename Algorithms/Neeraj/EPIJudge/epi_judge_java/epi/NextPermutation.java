package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    @EpiTest(testDataFile = "next_permutation.tsv")
    public static List<Integer> nextPermutation(List<Integer> perm) {
        int len = perm.size(), hIndex = len - 2;
        while (hIndex >= 0 && perm.get(hIndex) >= perm.get(hIndex + 1)) {
            hIndex--;
        }
        if (hIndex < 0) return Collections.emptyList();
        int lIndex = len - 1;
        while (lIndex > hIndex && perm.get(lIndex) <= perm.get(hIndex)) {
            lIndex--;
        }
//        Swap both the points and reverse.
        Collections.swap(perm, hIndex, lIndex);
        Collections.reverse(perm.subList(hIndex + 1, len));
        return perm;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "NextPermutation.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
