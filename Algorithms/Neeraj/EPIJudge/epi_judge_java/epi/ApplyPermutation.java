package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class ApplyPermutation {
    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        List<Integer> temp = new ArrayList<>(A);
        for (int i = 0; i < perm.size(); i++) {
            A.set(perm.get(i), temp.get(i));
        }
    }

    @EpiTest(testDataFile = "apply_permutation.tsv")
    public static List<Integer> applyPermutationWrapper(List<Integer> perm,
                                                        List<Integer> A) {
        applyPermutation(perm, A);
        return A;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ApplyPermutation.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
