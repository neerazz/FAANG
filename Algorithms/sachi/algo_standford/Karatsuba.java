package algo_standford;

/******************************************************************************
 *  Compilation:  javac Karatsuba.java
 *  Execution:    java Karatsuba N
 *
 *  Multiply two positive N-bit BigIntegers using Karatsuba multiplication.
 *
 *
 *  % java Karatsuba N
 *
 ******************************************************************************/

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

class Karatsuba {
    private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000)
            return x.multiply(y); // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b, y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }

    public static void main(String[] args) {
        long start, stop;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BigInteger a = new BigInteger(N, random);
        BigInteger b = new BigInteger(N, random);

        System.out.println(a);
        System.out.println(b);

        start = System.currentTimeMillis();
        BigInteger c = karatsuba(a, b);
        stop = System.currentTimeMillis();
        System.out.println("Karatsuba");
        System.out.println(stop - start);

        start = System.currentTimeMillis();
        BigInteger d = a.multiply(b);
        stop = System.currentTimeMillis();
        System.out.println("BigInteger");
        System.out.println(stop - start);

        System.out.println((c.equals(d)));
        scanner.close();
    }
}