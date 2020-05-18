package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class IntAsArrayMultiply {
    @EpiTest(testDataFile = "int_as_array_multiply.tsv")
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        long n1 = 0;
        int l1 = num1.size() - 1, l2 = num2.size() - 1, sign = num1.get(0) < 0 || num2.get(0) < 0 ? -1 : 1;
        BigInteger b1 = BigInteger.ZERO, b2 = BigInteger.ZERO;
        for (int i = 0; i <= l1; i++) {
            b1 = b1.add(BigInteger.valueOf((long) Math.pow(10, l1 - i) * Math.abs(num1.get(i))));
        }
        for (int i = 0; i <= l2; i++) {
            b2 = b2.add(BigInteger.valueOf((long) Math.pow(10, l2 - i) * Math.abs(num2.get(i))));
        }
        BigInteger bigInt = b1.multiply(b2);
        LinkedList<Integer> op = new LinkedList<>();
        while (bigInt.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] bigIntegers = bigInt.divideAndRemainder(BigInteger.valueOf((long) 10));
            if (bigIntegers.length == 2) {
                op.addFirst(bigIntegers[1].intValueExact());
            } else {
                op.addFirst(0);
            }
            bigInt = bigIntegers[0];
        }
        if (bigInt.equals(BigInteger.ZERO) && op.size() == 0) op.add(0);
        if (!op.isEmpty()) op.set(0, op.getFirst() * sign);
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
