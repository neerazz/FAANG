package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;

public class ThreeSum {

    @EpiTest(testDataFile = "three_sum.tsv")
    public static boolean hasThreeSum(List<Integer> A, int t) {
        Collections.sort(A);
        return nSum(A, t, 3);
    }

    private static boolean nSum(List<Integer> list, int target, int n) {
        if (n == 2) {
            return twoSum(list, target);
        } else {
            for (int end = 0; end < list.size(); end++) {
                if (nSum(list, target - list.get(end), n - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean twoSum(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int sum = list.get(start) + list.get(end);
            if (sum == target) return true;
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ThreeSum.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
