package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.List;

public class ConvertBase {
    static List<String> list = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F");

    @EpiTest(testDataFile = "convert_base.tsv")
    public static String convertBase(String numAsString, int b1, int b2) {
        if (numAsString == null || numAsString.length() == 0) return "0";
        boolean isNegative = false;
        if (numAsString.charAt(0) == '-') {
            isNegative = true;
        }
        long base10 = getBase10(numAsString.charAt(0) == '-' || numAsString.charAt(0) == '+' ? numAsString.substring(1) : numAsString, b1);
        String baseN = getBaseN(base10, b2);
        if (isNegative && baseN.length() > 0) baseN = "-".concat(baseN);
        return baseN.length() == 0 ? "0" : baseN;
    }

    private static String getBaseN(long base10, int base) {
        StringBuilder sb = new StringBuilder();
        while (base10 > 0) {
            sb.append(list.get((int) (base10 % base)));
            base10 /= base;
        }
        return sb.reverse().toString();
    }

    private static long getBase10(String input, int base) {
        long op = 0;
        int len = input.length();
        for (int i = 0; i < len; i++) {
            int pow = len - 1 - i;
            op += Math.pow(base, pow) * list.indexOf("" + input.charAt(i));
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
