package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.Arrays;

public class ReverseWords {

    public static void reverseWords(char[] input) {
        char[] temp = Arrays.copyOf(input, input.length);
        int index = input.length - 1, start = 0;
        while (index >= 0) {
            int p1 = index;
//            Loop till space is encountered.
            while (p1 >= 0 && temp[p1] != ' ') {
                p1--;
            }
            int p2 = p1 + 1;
            while (p2 <= index) {
                input[start++] = temp[p2++];
            }
            if (start < input.length) input[start++] = ' ';
            index = --p1;
        }
    }

    @EpiTest(testDataFile = "reverse_words.tsv")
    public static String reverseWordsWrapper(TimedExecutor executor, String s)
            throws Exception {
        char[] sCopy = s.toCharArray();

        executor.run(() -> reverseWords(sCopy));

        return String.valueOf(sCopy);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ReverseWords.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
