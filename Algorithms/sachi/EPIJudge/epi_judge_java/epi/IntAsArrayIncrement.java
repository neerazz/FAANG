package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntAsArrayIncrement {
    @EpiTest(testDataFile = "int_as_array_increment.tsv")
    public static List<Integer> plusOne(List<Integer> A) {
        // TODO - you fill in here.
        int carry = 1, sum = 0;
        for (int i = A.size() - 1; i >= 0; i--) {
            sum = carry + A.get(i);
            if (sum > 9) {
                carry = 1;
                A.set(i, 0);
            } else {
                carry = 0;
                A.set(i, sum);
            }
        }
        if (carry > 0) {
            A.set(0, 1);
            A.add(0);
        }
        return A;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
