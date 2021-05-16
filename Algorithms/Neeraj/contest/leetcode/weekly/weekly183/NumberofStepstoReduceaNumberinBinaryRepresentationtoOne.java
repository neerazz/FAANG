package weekly.weekly183;

import java.math.BigInteger;

/**
 * Crated on:  Apr 04, 2020
 */
public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
        System.out.println(numSteps("10"));
        System.out.println(numSteps("1"));
    }

    public static int numSteps(String s) {
        BigInteger input = new BigInteger(s, 2);
        int steps = 0;
        while (input.intValue() != 1) {
            BigInteger remainder = input.remainder(BigInteger.TWO);
            if (remainder.intValue() == 1) {
                input = input.add(BigInteger.ONE);
            } else {
                input = input.divide(BigInteger.TWO);
            }
            steps++;
        }
        return steps;
    }
}
