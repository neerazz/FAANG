package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

public class StringIntegerInterconversion {

    public static String intToString(int x) {
        // TODO - you fill in here.
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
        }
        StringBuilder s = new StringBuilder();
        do {
            s.append((char) ('0' + Math.abs(x % 10)));
            x /= 10;
        } while (x != 0);
        if (isNegative) {
            s.append('-'); // Adds the negative sign back.
        }
        return s.reverse().toString();
    }

    public static int stringToInt(String s) {
        // TODO - you fill in here.
        //Input is "123" make it 123
        if (s == null || s.length() == 0) return 0;
        int solution = 0;
        for (int i = (s.charAt(0) == '-' ? 1 : 0); i < s.length(); ++i) {
            int digit = s.charAt(i) - '0';
            solution = solution * 10 + digit;
        }
        return s.charAt(0) == '-' ? -solution : solution;
    }

    @EpiTest(testDataFile = "string_integer_interconversion.tsv")
    public static void wrapper(int x, String s) throws TestFailure {
        if (!intToString(x).equals(s)) {
            throw new TestFailure("Int to string conversion failed");
        }
        if (stringToInt(s) != x) {
            throw new TestFailure("String to int conversion failed");
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
