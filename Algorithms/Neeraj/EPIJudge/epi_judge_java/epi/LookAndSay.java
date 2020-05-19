package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Stack;

public class LookAndSay {

    @EpiTest(testDataFile = "look_and_say.tsv")
    public static String lookAndSay(int n) {
        if (n < 0) return "";
        String str = "1";
        if (n == 1) return str;
        for (int i = 2; i <= n; i++) {
            str = getNext(str);
        }
        return str;
    }

    private static String getNext(String str) {
        Stack<int[]> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] == c - '0') {
                count += stack.pop()[1];
            }
            stack.add(new int[]{c - '0', count});
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            sb.append(pop[0]).append(pop[1]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
