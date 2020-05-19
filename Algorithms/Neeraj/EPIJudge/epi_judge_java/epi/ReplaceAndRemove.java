package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;

public class ReplaceAndRemove {

    public static int replaceAndRemove(int size, char[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length && i < size; i++) {
            if (s[i] == 'a') {
                sb.append("dd");
            } else if (s[i] != 'b' && s[i] != ' ') {
                sb.append(s[i]);
            }
        }
        String string = sb.toString();
        for (int i = 0; i < string.length(); i++) {
            s[i] = string.charAt(i);
        }
        return string.length();
    }

    @EpiTest(testDataFile = "replace_and_remove.tsv")
    public static List<String>
    replaceAndRemoveWrapper(TimedExecutor executor, Integer size, List<String> s)
            throws Exception {
        char[] sCopy = new char[s.size()];
        for (int i = 0; i < size; ++i) {
            if (!s.get(i).isEmpty()) {
                sCopy[i] = s.get(i).charAt(0);
            }
        }

        Integer resSize = executor.run(() -> replaceAndRemove(size, sCopy));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < resSize; ++i) {
            result.add(Character.toString(sCopy[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ReplaceAndRemove.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
