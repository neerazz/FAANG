package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public static String majoritySearch(Iterator<String> stream) {
        Map<String, Integer> map = new HashMap<>();
        String op = "", cur;
        int max = 0;
        while (stream.hasNext()) {
            cur = stream.next();
            int count = map.getOrDefault(cur, 0);
            map.put(cur, count + 1);
            if (count + 1 > max) {
                op = cur;
                max = count + 1;
            }
        }
        return op;
    }

    @EpiTest(testDataFile = "majority_element.tsv")
    public static String majoritySearchWrapper(List<String> stream) {
        return majoritySearch(stream.iterator());
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "MajorityElement.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
