package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class DirectoryPathNormalization {

    @EpiTest(testDataFile = "directory_path_normalization.tsv")
    public static String shortestEquivalentPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        if (path.charAt(0) == '/') {
            list.addFirst("/");
        }
        String[] split = path.split("/");
        for (String val : split) {
            if (val.equals("..")) {
                if (list.isEmpty() || list.getLast().equals("..")) {
                    list.addLast(val);
                } else {
                    list.removeLast();
                }
            } else if (!val.equals(".") && !val.isEmpty()) {
                list.add(val);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) {
            sb.append(list.getFirst());
            int index = 1;
            while (index < list.size()) {
//                Add '/' only if the previous element in the list is not '/'.
                if (!list.get(index - 1).equals("/")) {
                    sb.append("/");
                }
                sb.append(list.get(index++));
            }
        }
        return sb.toString();
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
