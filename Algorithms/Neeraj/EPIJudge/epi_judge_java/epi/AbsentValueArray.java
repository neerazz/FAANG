package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AbsentValueArray {

    public static int findMissingElement(Iterable<Integer> stream) {
        List<Integer> pq = new ArrayList<>();
        stream.forEach(pq::add);
        int index =0, op =-1;
        for(int val: pq){
            op = op ^ val ^ index++;
        }
        return op;
    }

    @EpiTest(testDataFile = "absent_value_array.tsv")
    public static void findMissingElementWrapper(List<Integer> stream)
            throws Exception {
        try {
            int res = findMissingElement(stream);
            if (stream.stream().filter(a -> a.equals(res)).findFirst().isPresent()) {
                throw new TestFailure(String.valueOf(res) + " appears in stream");
            }
        } catch (IllegalArgumentException e) {
            throw new TestFailure("Unexpected no missing element exception");
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "AbsentValueArray.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
