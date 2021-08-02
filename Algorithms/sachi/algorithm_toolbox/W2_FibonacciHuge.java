package algorithm_toolbox;

import java.math.BigInteger;
import java.util.Scanner;

public class W2_FibonacciHuge {

    //Given two integers 𝑛 and 𝑚, output 𝐹𝑛 mod 𝑚 (that is, the remainder of 𝐹𝑛 when divided by 𝑚).
    //SOL: Pisano series -> Starts with 0,1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
        //testProgram();
    }

    private static long getPisano(long m) {
        //System.out.println("Calculating Pisano for " + m);
        long f = 0, s = 1, sum = 0, i = 0;
        while (true) {
            i++;
            sum = (f + s) % m;
            f = s;
            s = sum;
            if (f == 0 && s == 1) return i;
        }
    }

    private static String getFibonacciHugeFast(long n, long m) {
        long pisano = getPisano(m);
        //System.out.println("Pisano for " + m + " is " + pisano);
        if (pisano > n) {
            //System.out.println("Since Pisano is greater - Going normal route");
            return String.valueOf(getFibonacciNumber(n).mod(new BigInteger(String.valueOf(m))));
        } else {
            //System.out.println("Since Pisano is smaller - Calculating shorter");
            return String.valueOf(getFibonacciNumber(n % pisano).mod(new BigInteger(String.valueOf(m))));
        }
    }

    private static BigInteger getFibonacciNumber(long n) {
        if (n == 0) return new BigInteger("0");
        if (n == 1) return new BigInteger("1");
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        BigInteger sum = new BigInteger("0");
        for (long i = 1; i < n; i++) {
            sum = first.add(second);
            first = second;
            second = sum;
        }
        return sum;
    }

    //Test Program with naive
    private static void testProgram() {
        long n = (long) (Math.random() * 100);
        long m = (long) (Math.random() * 10);
        System.out.println("Input F(" + n + ") mod " + m);
        while (true) {
            String naive = String.valueOf(getFibonacciHugeNaive(n, m));
            String quick = getFibonacciHugeFast(n, m);
            if (!naive.equals(quick)) {
                System.out.println("Failed for Input F(" + n + ") mod " + m);
                System.out.println("Naive: " + naive + " Quick is " + quick);
                break;
            }
        }
    }


    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current = 1;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return current % m;
    }

}
