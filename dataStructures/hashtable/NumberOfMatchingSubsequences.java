import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Jul 31, 2021
 * Ref : https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Seq>> map = new HashMap<>();
        for (String word : words) {
            addWord(map, 0, word);
        }
        int count = 0;
        for (char cur : s.toCharArray()) {
            List<Seq> curWords = map.remove(cur);
            if (curWords == null) continue;
            for (Seq seq : curWords) {
                if (seq.idx == seq.word.length() - 1) {
                    count++;
                } else {
                    addWord(map, seq.idx + 1, seq.word);
                }
            }
        }
        return count;
    }

    private static void addWord(Map<Character, List<Seq>> map, int idx, String word) {
        char start = word.charAt(idx);
        map.computeIfAbsent(start, cal -> new ArrayList<>()).add(new Seq(word, idx));
    }

    static class Seq {
        String word;
        int idx;

        Seq(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }

        public String toString() {
            return word + " idx -> " + idx;
        }
    }
}
