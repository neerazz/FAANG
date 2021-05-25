package y2021.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created on:  May 16, 2021
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a8e6#problem
 */

public class ConsecutivePrimes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            result[i] = getNumber(sc.nextLong());
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    static Set<Long> primes;

    private static long getNumber(long num) {
        primes = new HashSet<>();
        long pre = 2, cur = 3, max = 2;
        while (pre * cur <= num) {
            max = Math.max(max, pre * cur);
            pre = cur;
//            Calculate the next prime.
            cur = next(++cur);
        }
        return max;
    }

    private static long next(long n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(long n) {
        if (n == 2 || n == 3) return true;
//        If the number is divisible by 2 or 3 then it is not prime.
        if (n % 2 == 0 || n % 3 == 0) return false;
//        If the number is a perfect square, then it cannot be a prime number.
        if (isPerfectSquare(n)) return false;
//        Loop through all the prime numbers collected so far and check if n is divisible with that prime.
        for (long prime : primes) {
            if (n % prime == 0) return false;
        }
        primes.add(n);
        return true;
    }

    private static boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
