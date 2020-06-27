package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class Fibonacci {

    @EpiTest(testDataFile = "fibonacci.tsv")
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        int pre = 0, cur = 1;
        for (int i = 1; i < n; i++) {
            int temp = cur + pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "Fibonacci.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
