import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/problems/shortest-word-distance/
 * <p>
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 * <p>
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 */
public class ShortestWordDistance {
    public static void main(String[] args) {

    }

    public static int shortestDistance_rev1(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1, min = Integer.MAX_VALUE, len = words.length;
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) i1 = i;
            if (words[i].equals(word2)) i2 = i;
//            When both the words are found.
            if (i1 != -1 && i2 != -1) {
                min = Math.min(min, Math.abs(i1 - i2));
            }
        }
        return min;
    }

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int len = wordsDict.length;
        for (int i = 0; i < len; i++) {
            String word = wordsDict[i];
            map.computeIfAbsent(word, val -> new ArrayList<>()).add(i);
        }
        List<Integer> a = map.get(word1), b = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int v1 : a) {
            for (int v2 : b) {
                min = Math.min(min, Math.abs(v1 - v2));
            }
        }
        return min;
    }
}
