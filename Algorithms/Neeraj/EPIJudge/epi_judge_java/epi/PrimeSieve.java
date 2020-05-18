package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSieve {
    @EpiTest(testDataFile = "prime_sieve.tsv")
    // Given n, return all primes up to and including n.
    public static List<Integer> generatePrimes(int n) {
        List<Integer> op = new ArrayList<>();
        if (n < 2) return op;
        boolean[] isNotPrime = new boolean[n+1];
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                for (int j = 2; j * i <= n; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                op.add(i);
            }
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
