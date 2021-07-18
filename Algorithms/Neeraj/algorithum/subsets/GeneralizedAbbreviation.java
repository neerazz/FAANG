import java.util.*;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/NEOZDEg5PlN
 */

public class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<>();
        Queue<AbbreviateWord> queue = new LinkedList<>();
//        Initially dont take any word.
        queue.add(new AbbreviateWord(new StringBuilder(), 0, 0));
        int len = word.length();
        while (!queue.isEmpty()) {
            AbbreviateWord poll = queue.poll();
            if (poll.start == len) {
//                Pointer have reached the last word. Append counter to stringbuilder and ad to result.
                if (poll.count != 0) poll.sb.append(poll.count);
                result.add(poll.sb.toString());
            } else {
//                Increase the index
//                Add the current char to counter, and carry the counter.
                queue.add(new AbbreviateWord(new StringBuilder(poll.sb), poll.start + 1, poll.count + 1));

//                Add add the so far counter to the string also add the character to string.
                if (poll.count != 0) poll.sb.append(poll.count);
                queue.add(new AbbreviateWord(new StringBuilder(poll.sb.append(word.charAt(poll.start))), poll.start + 1, 0));
            }
        }
        return result;
    }

    public static List<String> generateGeneralizedAbbreviation_recursion(String word) {
        List<String> result = new ArrayList<String>();
        helper(word, 0, "", 0, result);
        return result;
    }

    static void helper(String word, int i, String pre, int preCount, List<String> result) {
        if (i == word.length()) {
            result.add(getString(pre, preCount));
        } else {
            helper(word, i + 1, pre, preCount + 1, result);
            helper(word, i + 1, getString(pre, preCount) + word.charAt(i), 0, result);
        }
    }

    static String getString(String str, int count) {
        return str + (count == 0 ? "" : count);
    }

    static class AbbreviateWord {
        StringBuilder sb;
        int start, count;

        public AbbreviateWord(StringBuilder sb, int start, int count) {
            this.sb = sb;
            this.start = start;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 *************************************");
        System.out.println(generateGeneralizedAbbreviation("BAT"));
        System.out.println(generateGeneralizedAbbreviation("code"));

        System.out.println("****************************** Solution 2 *************************************");
        System.out.println(generateGeneralizedAbbreviation_recursion("BAT"));
        System.out.println(generateGeneralizedAbbreviation_recursion("code"));
    }
}
