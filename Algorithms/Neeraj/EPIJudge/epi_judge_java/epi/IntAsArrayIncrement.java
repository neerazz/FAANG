package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.LinkedList;
import java.util.List;

public class IntAsArrayIncrement {
    @EpiTest(testDataFile = "int_as_array_increment.tsv")
    public static List<Integer> plusOne(List<Integer> A) {
        LinkedList<Integer> op = new LinkedList<>();
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            op.addFirst((A.get(i) + carry) % 10);
            carry = (A.get(i) + carry) / 10;
        }
        if (carry > 0) {
            op.addFirst(carry);
        }
        return op;
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
