package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;
import epi.test_framework.LexicographicalListComparator;

import java.util.*;

public class Permutations {
    static List<List<Integer>> result;

    @EpiTest(testDataFile = "permutations.tsv")
    public static List<List<Integer>> permutations(List<Integer> A) {
        result = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        helper(new LinkedList<>(), set);
        return result;
    }

    private static void helper(LinkedList<Integer> soFar, Set<Integer> set) {
        if (set.isEmpty()) {
            result.add(new ArrayList<>(soFar));
        } else {
            Set<Integer> temp = new HashSet<>(set);
            for (int val : set) {
                temp.remove(val);
                soFar.add(val);
                helper(soFar, temp);
                soFar.removeLast();
                temp.add(val);
            }
        }
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
                        .runFromAnnotations(args, "Permutations.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
