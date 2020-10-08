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
        System.out.println(result.size());
        return result;
    }

    public static List<String> generateGeneralizedAbbreviation_Wrong(final String word) {
        final Set<String> result = new HashSet<>();
        helper(word, "", 0, "", result, word.length());
        System.out.println(result.size());
        return new ArrayList<>(result);
    }

    private static void helper(String word, String prefix, int start, String suffix, Set<String> result, int length) {
        if (start == word.length()) {
            result.add("" + word.length());
            result.add(word);
            return;
        }
        for (int i = start; i < length; i++) {
//            Set the current range with numbers.
            int curlen = i - start + 1;
            result.add(prefix + curlen + word.substring(i + 1));
            helper(word, prefix + curlen, i + 1, suffix, result, length);
//            Set the current character and the remaining to numbers.
            result.add(prefix + word.substring(start, i + 1) + (i == length ? "" : length - i));
            helper(word, prefix + word.substring(start, i + 1), i + 1, suffix, result, length);
        }
    }

    static class AbbreviateWord {
        StringBuilder sb;
        int start, count;

        public AbbreviateWord(final StringBuilder sb, final int start, final int count) {
            this.sb = sb;
            this.start = start;
            this.count = count;
        }
    }

    public static void main(final String[] args) {
        List<String> result = generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
