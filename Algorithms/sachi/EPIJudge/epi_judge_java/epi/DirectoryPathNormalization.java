package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Deque;
import java.util.LinkedList;

public class DirectoryPathNormalization {
    @EpiTest(testDataFile = "directory_path_normalization.tsv")

    public static String shortestEquivalentPath(String path) {
        boolean startWithSlash = false;
        if (path == null || path.length() == 0) return path;
        if (path.charAt(0) == '/') {
            startWithSlash = true;
        }
        Deque<String> stack = new LinkedList<>();
        String[] list = path.split("/");
        for (String s : list) {

            // . is ignore
            if (".".equals(s)) {
                continue;
            }

            // .. parent -> Go back two steps
            if ("..".equals(s) && stack.peek() != null && !stack.peek().equals("..")) {
                stack.pop();
                continue;
            }

            // Add last elem - Even /
            if (!"/".equals(s)) {
                stack.push(s);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (startWithSlash) {
            builder.append("/");
        }
        while (!stack.isEmpty()) {
            builder.append(stack.removeLast())
                    .append("/");
        }

        if (builder.length() > 1) {
            return builder.deleteCharAt(builder.length() - 1).toString();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "DirectoryPathNormalization.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
