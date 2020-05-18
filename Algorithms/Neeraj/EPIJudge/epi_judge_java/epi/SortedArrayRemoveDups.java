package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.List;

public class SortedArrayRemoveDups {
    // Returns the number of valid entries after deletion.
    public static int deleteDuplicates(List<Integer> A) {
        int nd = 0, p1 = 0, p2 = 0;
        while (p2 < A.size()) {
            if (A.get(p1).equals(A.get(p2))) {
                p2++;
            } else {
                A.set(nd++, A.get(p1));
                p1 = p2;
            }
        }
        if (p1 != p2) A.set(nd++, A.get(p1));
        return nd;
    }

    @EpiTest(testDataFile = "sorted_array_remove_dups.tsv")
    public static List<Integer> deleteDuplicatesWrapper(TimedExecutor executor,
                                                        List<Integer> A)
            throws Exception {
        int end = executor.run(() -> deleteDuplicates(A));
        return A.subList(0, end);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortedArrayRemoveDups.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
