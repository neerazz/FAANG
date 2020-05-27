package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

public class StringIntegerInterconversion {

    public static String intToString(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            sb.append(isNegative ? -1 * (x % 10) : x % 10);
            x /= 10;
        }
        return sb.length() == 0 ? "0" : sb.append(isNegative ? "-" : "").reverse().toString();
    }

    public static int stringToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean isNegative = false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            isNegative = s.charAt(0) == '-';
            s = s.substring(1);
        }
        int op = 0;
        for (int i = 0; i < s.length(); i++) {
            op = (op * 10) + (s.charAt(i) - '0');
        }
        return isNegative && s.length() > 0 ? op * -1 : op;
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
