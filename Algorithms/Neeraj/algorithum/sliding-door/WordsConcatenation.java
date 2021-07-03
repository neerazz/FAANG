import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/Y5YDWzqPn7O
 */

public class WordsConcatenation {

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 ******************************");
        System.out.println(findWordConcatenation_naive("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation_naive("catcatfoxfox", new String[]{"cat", "fox"}));
        System.out.println("****************************** Solution 2 ******************************");
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length;
        int wordLen = words[0].length();

//        Loop from starting till the point where there are wordsCount * wordLen chars left.
        for (int i = 0; i <= str.length() - wordsCount * wordLen; i++) {
            Map<String, Integer> window = new HashMap<>();
//            Find occurrence of each word.
            for (int j = 0; j < wordsCount; j++) {
                int wordIdx = i + j * wordLen;
                String word = str.substring(wordIdx, wordIdx + wordLen);
//                If the word is not present then break.
                if (!wordMap.containsKey(word)) break;

                window.put(word, window.getOrDefault(word, 0) + 1);

//                If the the word is present more number of times then in the word len then break. It is not correct possibility.
                if (window.get(word) > wordMap.get(word)) break;
//                Then you have found all the words
                if (j == wordsCount - 1) resultIndices.add(i);
            }
        }
        return resultIndices;
    }

    public static List<Integer> findWordConcatenation_naive(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<>();
        int wordsLen = words.length, wordLen = words[0].length(), len = str.length();
        boolean[] taken = new boolean[wordsLen];
        for (int i = 0; i < len; i++) {
            String cur = str.substring(i);
            for (int j = 0; j < wordsLen; j++) {
                if (cur.startsWith(words[j])) {
                    taken[j] = true;
                    helper(str, i + wordLen, words, taken, 1, resultIndices, i);
                    taken[j] = false;
                }
            }
        }
        return resultIndices;
    }

    private static void helper(String str, int start, String[] words, boolean[] taken, int foundSoFar, List<Integer> resultIndices, int starting) {
        if (foundSoFar == words.length) {
            resultIndices.add(starting);
            return;
        }
        if (str.length() <= start) return;
        String cur = str.substring(start);
        for (int j = 0; j < words.length; j++) {
            if (taken[j]) continue;
            if (cur.startsWith(words[j])) {
                taken[j] = true;
                helper(str, start + words[0].length(), words, taken, foundSoFar + 1, resultIndices, starting);
                taken[j] = false;
            }
        }
    }
}
