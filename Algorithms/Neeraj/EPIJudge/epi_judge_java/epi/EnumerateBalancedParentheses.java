package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.*;

public class EnumerateBalancedParentheses {

    static Set<String> set;
    static Map<String, List<String>> memo;

    @EpiTest(testDataFile = "enumerate_balanced_parentheses.tsv")
    public static List<String> generateBalancedParentheses(int numPairs) {
        set = new HashSet<>();
        memo = new HashMap<>();
        helper_topToBottom(numPairs, 0, 0, "");
        return new ArrayList<>(set);
//        return helper_buttomToTop(numPairs, 0, 0);
    }

    private static void helper_buttomToTop(int numPairs, int open, int close) {
    }

    private static void helper_topToBottom(int numPairs, int open, int close, String soFar) {
        if (numPairs < open || numPairs < close) return;
        if (numPairs == open && numPairs == close) {
            set.add(soFar);
        } else {
            if (open < numPairs) {
                helper_topToBottom(numPairs, open + 1, close, soFar + "(");
            }
            if (close < open) {
                helper_topToBottom(numPairs, open, close + 1, soFar + ")");
            }
        }
    }

    @EpiTestComparator
    public static boolean comp(List<String> expected, List<String> result) {
        if (result == null) {
            return false;
        }
        Collections.sort(expected);
        Collections.sort(result);
        return expected.equals(result);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "EnumerateBalancedParentheses.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
