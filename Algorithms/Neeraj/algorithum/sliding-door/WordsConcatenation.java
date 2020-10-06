import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/Y5YDWzqPn7O
 */

public class WordsConcatenation {

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }

    public static List<Integer> findWordConcatenation_correct(String str, String[] words) {
        Map<Integer, Set<String>> idxs = new HashMap<>();
        for (String word : words) {
            getIdxs(str, word, idxs);
        }
        List<Integer> resultIndices = new ArrayList<>();

        return resultIndices;
    }

    private static void getIdxs(String str, String cur, Map<Integer, Set<String>> idxs) {
        int start = 0, p1 = 0, len = str.length(), p2 = 0;
        while (p1 < len) {
            if (str.charAt(p1) == cur.charAt(p2)) {
                if(p2 == cur.length()-1) {
                    idxs.computeIfAbsent(start, val -> new HashSet<>()).add(cur);
                    p1++;
                    start = p1;
                    p2 =0;
                }else{
                    p2++;
                    p1++;
                }
            } else {
                p1 = start + 1;
                p2 = 0;
            }
        }
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> wordMap = new HashMap<>();
        int wordLength = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
                wordLength++;
            }
        }
        Map<Character, Integer> window = new HashMap<>();
        int len = str.length(), found = 0, p1 = 0, p2 = 0;
        while (p2 < len) {
            char right = str.charAt(p2);
            if (wordMap.containsKey(right)) {
                window.put(right, window.getOrDefault(right, 0) + 1);
                if (wordMap.get(right) == window.get(right)) found++;
                while (p2 - p1 + 1 > wordLength) {
                    char left = str.charAt(p1++);
                    if (!wordMap.containsKey(left)) continue;
                    int count = window.remove(left);
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
