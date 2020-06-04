package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class SearchFirstKey {
    @EpiTest(testDataFile = "search_first_key.tsv")
    public static int searchFirstOfK(List<Integer> A, int k) {
        int start = 0, end = A.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == k) {
                end = mid;
            } else if (A.get(mid) < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start == end && A.get(start) == k) return start;
        return -1;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SearchFirstKey.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
