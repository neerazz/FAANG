package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

public class StringIntegerInterconversion {

    public static String intToString(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
//            x *= -1;
        }
        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            sb.append(isNegative ? -1 * digit : digit);
        }
        return sb.length() == 0 ? "0" : sb.append(isNegative ? "-" : "").reverse().toString();
    }

    public static int stringToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        return (s.charAt(0) == '-' ? -1 : 1) *
                s.substring(s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0)
                        .chars()
                        .reduce(0, (sum, c) -> sum * 10 + c - '0');
    }

    @EpiTest(testDataFile = "string_integer_interconversion.tsv")
    public static void wrapper(int x, String s) throws TestFailure {
        if (Integer.parseInt(intToString(x)) != x) {
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
