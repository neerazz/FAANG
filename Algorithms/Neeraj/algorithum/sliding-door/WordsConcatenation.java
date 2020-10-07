import java.util.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/Y5YDWzqPn7O
 */

public class WordsConcatenation {

    public static void main(final String[] args) {
        System.out.println(WordsConcatenation.findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(WordsConcatenation.findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }

    public static List<Integer> findWordConcatenation_correct(final String str, final String[] words) {
        final Map<String, Integer> wordMap = new HashMap<>();
        for (final String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        final List<Integer> resultIndices = new ArrayList<>();
        final int wordsCount = words.length;
        final int wordLen = words[0].length();

//        Loop from starting till the point where there are wordsCount * wordLen chars left.
        for (int i = 0; i <= str.length() - wordsCount * wordLen; i++) {
            final Map<String, Integer> window = new HashMap<>();
//            Find occurrence of each word.
            for (int j = 0; j < wordsCount; j++) {
                final int wordIdx = i + j * wordLen;
                final String word = str.substring(wordIdx, wordIdx + wordLen);
//                If the word is not present then break.
                if (!wordMap.containsKey(word)) break;

                window.put(word, window.getOrDefault(word, 0) + 1);

//                If the the word is present more number of times then in the word len then break. It is not correct possibility.
                if (window.get(word) > wordMap.get(word)) break;
//                THen you have found all teh words
                if (j == wordsCount - 1) resultIndices.add(i);
            }
        }
        return resultIndices;
    }

    private static void getIdxs(final String str, final String cur, final Map<Integer, Set<String>> idxs) {
        int start = 0;
        int p1 = 0;
        final int len = str.length();
        int p2 = 0;
        while (p1 < len) {
            if (str.charAt(p1) == cur.charAt(p2)) {
                if (p2 == cur.length() - 1) {
                    idxs.computeIfAbsent(start, val -> new HashSet<>()).add(cur);
                    p1++;
                    start = p1;
                    p2 = 0;
                } else {
                    p2++;
                    p1++;
                }
            } else {
                p1 = start + 1;
                p2 = 0;
            }
        }
    }

    public static List<Integer> findWordConcatenation(final String str, final String[] words) {
        final List<Integer> resultIndices = new ArrayList<Integer>();
        final Map<Character, Integer> wordMap = new HashMap<>();
        int wordLength = 0;
        for (final String word : words) {
            for (final char c : word.toCharArray()) {
                wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
                wordLength++;
            }
        }
        final Map<Character, Integer> window = new HashMap<>();
        final int len = str.length();
        int found = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < len) {
            final char right = str.charAt(p2);
            if (wordMap.containsKey(right)) {
                window.put(right, window.getOrDefault(right, 0) + 1);
                if (wordMap.get(right) == window.get(right)) found++;
                while (p2 - p1 + 1 > wordLength) {
                    final char left = str.charAt(p1++);
                    if (!wordMap.containsKey(left)) continue;
                    final int count = window.remove(left);
                    if (count > 1) window.put(left, count - 1);
                    if (count == wordMap.get(left)) found--;
                }
                if (found == wordMap.size()) {
                    resultIndices.add(p1);
                }
            } else {
                window.clear();
                p1 = p2 + 1;
            }
            p2++;
        }
        return resultIndices;
    }
}
