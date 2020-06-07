package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.*;

public class SmallestSubarrayCoveringSet {

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph,
                                                           Set<String> keywords) {
        int p1 = 0, p2 = 0;
        Map<String, Integer> map = new HashMap<>();
        int[] res = {Integer.MAX_VALUE, 0, 0};
        while (p2 < paragraph.size()) {
            String cur = paragraph.get(p2);
            if (keywords.contains(cur)) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            while (map.size() == keywords.size()) {
                if (p2 - p1 + 1 < res[0]) {
                    res = new int[]{p2 - p1 + 1, p1, p2};
                }
                cur = paragraph.get(p1);
                if (keywords.contains(cur)) {
                    if (map.get(cur) > 1) {
                        map.put(cur, map.get(cur) - 1);
                    } else {
                        map.remove(cur);
                    }
                }
                p1++;
            }
            p2++;
        }
        return new Subarray(res[1], res[2]);
    }

    @EpiTest(testDataFile = "smallest_subarray_covering_set.tsv")
    public static int findSmallestSubarrayCoveringSetWrapper(
            TimedExecutor executor, List<String> paragraph, Set<String> keywords)
            throws Exception {
        Set<String> copy = new HashSet<>(keywords);

        Subarray result = executor.run(
                () -> findSmallestSubarrayCoveringSet(paragraph, keywords));

        if (result.start < 0 || result.start >= paragraph.size() ||
                result.end < 0 || result.end >= paragraph.size() ||
                result.start > result.end)
            throw new TestFailure("Index out of range");

        for (int i = result.start; i <= result.end; i++) {
            copy.remove(paragraph.get(i));
        }

        if (!copy.isEmpty()) {
            throw new TestFailure("Not all keywords are in the range");
        }
        return result.end - result.start + 1;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SmallestSubarrayCoveringSet.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    // Represent subarray by starting and ending indices, inclusive.
    private static class Subarray {
        public Integer start;
        public Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }
}
