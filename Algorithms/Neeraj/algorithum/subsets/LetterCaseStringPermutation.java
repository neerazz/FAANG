import java.util.*;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/xVlKmyX542P
 */

public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations_dp(String str) {
        Map<Integer, List<String>> dp = new HashMap<>();
        return dp(str, 0, str.length(), dp);
    }

    static List<String> dp(String str, int start, int end, Map<Integer, List<String>> dp) {
        if (start == end) return Arrays.asList("");
        if (dp.containsKey(start)) return dp.get(start);
        List<String> result = new ArrayList<>();
        char curChar = str.charAt(start);
        List<String> next = dp(str, start + 1, end, dp);
        boolean isChar = Character.isLetter(curChar);
        for (String nextStr : next) {
            if (isChar) {
                result.add(Character.toLowerCase(curChar) + nextStr);
                result.add(Character.toUpperCase(curChar) + nextStr);
            } else {
                result.add(curChar + nextStr);
            }
        }
        dp.put(start, result);
        return result;
    }

    public static List<String> findLetterCaseStringPermutations(String str) {
        int level = 0;
        int len = str.length();
        Queue<char[]> queue = new LinkedList<>();
        queue.add(str.toCharArray());
        while (level < len) {
            int size = queue.size();
            if (!Character.isDigit(str.charAt(level))) {
                for (int i = 0; i < size; i++) {
                    char[] poll = queue.poll();
                    char cur = poll[level];
                    poll[level] = Character.toLowerCase(cur);
                    queue.add(Arrays.copyOf(poll, len));
                    poll[level] = Character.toUpperCase(cur);
                    queue.add(Arrays.copyOf(poll, len));
                }
            }
            level++;
        }
        List<String> result = new ArrayList();
        while (!queue.isEmpty()) {
            result.add(String.valueOf(queue.poll()));
        }
        return result;
//        return queue.stream().map(chars -> String.valueOf(chars)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
