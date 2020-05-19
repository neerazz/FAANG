package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.stream.Collectors;

public class IsStringPalindromicPunctuation {

    @EpiTest(testDataFile = "is_string_palindromic_punctuation.tsv")
    public static boolean isPalindrome(String s) {
        String stripped = s.chars().filter(Character::isLetterOrDigit).mapToObj(c -> String.valueOf((char) c)).map(String::toLowerCase).collect(Collectors.joining());
        int p1 = 0, p2 = stripped.length() - 1;
        while (p1 < p2) {
            if (stripped.charAt(p1++) != stripped.charAt(p2--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsStringPalindromicPunctuation.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
