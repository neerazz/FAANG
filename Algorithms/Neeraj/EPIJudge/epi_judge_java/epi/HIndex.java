package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;

public class HIndex {
    @EpiTest(testDataFile = "h_index.tsv")
    public static int hIndex(List<Integer> citations) {
        int result = 0, equalAndGreater = 0;
        Collections.sort(citations);
//        Start from end, and keep the count of citations.
//          if number of citations soFar is greater than then current value. That could be the answer.
//        Keep the max of all possible answers.
        for (int i = citations.size() - 1; i >= 0; i--) {
            equalAndGreater++;
            if (citations.get(i) >= equalAndGreater) result = Math.max(result, equalAndGreater);
        }
        return result;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "HIndex.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
