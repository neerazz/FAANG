package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class FirstMissingPositiveEntry {
    @EpiTest(testDataFile = "first_missing_positive_entry.tsv")

    public static int findFirstMissingPositive(List<Integer> A) {
        int len = A.size();
        for (int i = 0; i < len; i++) {
            int cur = A.get(i);
            if (cur <= 0 || cur > len) {
                A.set(i, len + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            int cur = Math.abs(A.get(i));
            if (cur > len) {
                continue;
            }
//            Set the remote value to negative
            int rem = A.get(cur - 1);
//            prevents double negative operations
            if (rem > 0)
                A.set(cur - 1, -1 * rem);
        }
        for (int i = 0; i < len; i++) {
            if (A.get(i) >= 0) return i + 1;
        }
        return len + 1;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "FirstMissingPositiveEntry.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
