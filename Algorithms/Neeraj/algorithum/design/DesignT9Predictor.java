import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jul 20, 2021
 * Ref : https://leetcode.com/discuss/interview-question/685338/Microsoft-or-Onsite-or-Design-the-T9-predictive-text-algorithm-and-system
 * https://www.youtube.com/watch?v=PIeiiceWe_w&t=1444s
 */
public class DesignT9Predictor {
    public static void main(String[] args) {
        T9Predictor t9Predictor = new T9Predictor(new String[]{"mane", "name", "oboe", "ocndabc", "oandab", "mcoefg", "nazzz", "abcdef", "adb"});
        System.out.println(t9Predictor.words("6263"));
        System.out.println(t9Predictor.words("626"));
        System.out.println(t9Predictor.words("62"));
        System.out.println(t9Predictor.words(""));
        System.out.println(t9Predictor.words("2"));
        System.out.println(t9Predictor.words("22"));
    }
}

class T9Predictor {

    Trie trie;

    T9Predictor(String[] words) {
        trie = new Trie(' ');
        for (String word : words) {
            trie.addNode(word, 0);
        }
    }

    Set<String> words(String prefix) {
        int[] map = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        char[] startChar = {' ', ' ', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        Set<String> result = new HashSet<>();
        dfs(prefix, 0, map, result, "", startChar);
        return result;
    }

    private void dfs(String prefix, int i, int[] map, Set<String> result, String soFar, char[] startChar) {
        if (i == prefix.length()) {
            result.addAll(trie.getTop(soFar, 0));
        } else {
            int cur = prefix.charAt(i) - '0';
//            No available prediction, if the digit is less then 2.
            if (cur < 2) return;
            int totalChars = map[cur];
            for (int j = 0; j < totalChars; j++) {
                String curString = soFar + ((char) (startChar[cur] + j));
                dfs(prefix, i + 1, map, result, curString, startChar);
            }
        }
    }

    class Trie {
        Trie[] tries;
        char cur;
        boolean isEnd;
        String preFix;
        Set<String> words;
        int max = 5;

        Trie(char cur) {
            this.cur = cur;
            tries = new Trie[26];
            words = new HashSet<>();
        }

        void addNode(String str, int i) {
            if (str.length() == i) {
                isEnd = true;
                preFix = str;
            } else {
                int cur = str.charAt(i) - 'a';
                if (tries[cur] == null) tries[cur] = new Trie(str.charAt(i));
                tries[cur].addNode(str, i + 1);
                tries[cur].addWord(str);
            }
        }

        void addWord(String str) {
            if (words.size() >= max) {
                words.remove(words.iterator().next());
            }
            words.add(str);
        }

        public Set<String> getTop(String prefix, int i) {
            if (i == prefix.length()) {
                return words;
            }
            int cur = prefix.charAt(i) - 'a';
            if (tries[cur] == null) return new HashSet<>();
            return tries[cur].getTop(prefix, i + 1);
        }
    }
}