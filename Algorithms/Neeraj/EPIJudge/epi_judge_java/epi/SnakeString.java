package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SnakeString {

    @EpiTest(testDataFile = "snake_string.tsv")
    public static String snakeString(String s) {
        int upper = 1, middle = 0, lower = 3, len = s.length();
        StringBuilder sb = new StringBuilder();
        while (upper < len) {
            sb.append(s.charAt(upper));
            upper += 4;
        }
        while (middle < len) {
            sb.append(s.charAt(middle));
            middle += 2;
        }
        while (lower < len) {
            sb.append(s.charAt(lower));
            lower += 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SnakeString.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
