package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.*;
import java.util.stream.Collectors;

public class PowerSet {
    @EpiTest(testDataFile = "power_set.tsv")
    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        return getCombinations(new LinkedList<>(inputSet));
    }

    private static List<List<Integer>> getCombinations(LinkedList<Integer> list) {
        if (list.isEmpty()) return Collections.singletonList(Collections.emptyList());
        int cur = list.removeFirst();
        List<List<Integer>> next = getCombinations(list);
        List<List<Integer>> level = new ArrayList<>(next);
        for (List<Integer> lst : next) {
            List<Integer> temp = new ArrayList<>(lst);
            temp.add(cur);
            level.add(temp);
        }
        return level;
    }

    @EpiTestComparator
    public static boolean comp(List<List<Integer>> expected,
                               List<List<Integer>> result) {
        if (result == null) {
            return false;
        }
        for (List<Integer> l : expected) {
            Collections.sort(l);
        }
        expected.sort(new LexicographicalListComparator<>());
        for (List<Integer> l : result) {
            Collections.sort(l);
        }
        result.sort(new LexicographicalListComparator<>());
        return expected.equals(result);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "PowerSet.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
