import java.util.*;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/xVlKmyX542P
 */

public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(final String str) {
        int level = 0;
        final int len = str.length();
        final Queue<char[]> queue = new LinkedList<>();
        queue.add(str.toCharArray());
        while (level < len) {
            final int size = queue.size();
            if (!Character.isDigit(str.charAt(level))) {
                for (int i = 0; i < size; i++) {
                    final char[] poll = queue.poll();
                    final char cur = poll[level];
                    poll[level] = Character.toLowerCase(cur);
                    queue.add(Arrays.copyOf(poll, len));
                    poll[level] = Character.toUpperCase(cur);
                    queue.add(Arrays.copyOf(poll, len));
                }
            }
            level++;
        }
        final List<String> result = new ArrayList();
        while (!queue.isEmpty()) {
            result.add(String.valueOf(queue.poll()));
        }
        return result;
//        return queue.stream().map(chars -> String.valueOf(chars)).collect(Collectors.toList());
    }

    public static void main(final String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
