package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;

public class IsStringPermutableToPalindrome {
    @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

    public static boolean canFormPalindrome(String s) {
        // TODO - you fill in here.

        if (s == null || s.length() == 0) return true;

        boolean allowMiss = !(s.length() % 2 == 0);

        HashMap<Character, Integer> charCounter = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (charCounter.containsKey(c)) {
                Integer count = charCounter.get(c);
                charCounter.put(c, ++count);
            } else {
                charCounter.put(c, 1);
            }
        }

        for (Integer values : charCounter.values()) {
            if (values%2 != 0) {
                if(allowMiss){
                    allowMiss = false;
                    continue;
                }
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
