package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {
    @EpiTest(testDataFile = "nearest_repeated_entries.tsv")
    public static int findNearestRepetition(List<String> paragraph) {
        int output = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paragraph.size(); i++) {
            String cur = paragraph.get(i);
            if (map.containsKey(cur)) {
                int pre = map.get(cur);
                if (i - pre < output) {
                    output = i - pre;
                }
            }
            map.put(cur, i);
        }
        return output == Integer.MAX_VALUE ? -1 : output;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "NearestRepeatedEntries.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
