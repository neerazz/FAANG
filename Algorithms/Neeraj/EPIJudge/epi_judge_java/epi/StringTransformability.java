package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class StringTransformability {

    @EpiTest(testDataFile = "string_transformability.tsv")
    public static int transformString(Set<String> D, String s, String t) {

        if (s.equals(t) || !D.contains(t)) return 0;
        Map<String, Integer> pathMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        pathMap.put(s, 0);
        while (!queue.isEmpty()) {
//                Get all the words from queue add the counter to path.
            String poll = queue.poll();
            if (poll.equals(t)) {
                return pathMap.get(t);
            }
            int curLen = pathMap.get(poll);
//                Substitute each char by [a -> z] and see if it is present.
            char[] chars = poll.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char cur = chars[j];
                for (int k = 0; k < 26; k++) {
                    char temp = (char) ('a' + k);
                    if (temp != cur) {
                        chars[j] = temp;
//                            Check if the current string is present in the given dictonary.
                        String curStr = String.valueOf(chars);
                        if (D.remove(curStr)) {
                            pathMap.put(curStr, curLen + 1);
                            queue.add(curStr);
                        }
                    }
                }
                chars[j] = cur;
            }
        }
        return pathMap.getOrDefault(t, -1);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "StringTransformability.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
