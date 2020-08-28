import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Aug 23, 2020
 * Questions: https://leetcode.com/problems/stream-of-characters/
 */
public class StreamOfCharacters {
    public static void main(String[] args) {

    }

    static class StreamChecker {
        Node head = new Node();
        List<Character> queries = new ArrayList<>();

        public StreamChecker(String[] words) {
            for (String word : words) {
                Node cur = head;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    if (cur.dep[c - 'a'] == null) {
                        cur.dep[c - 'a'] = new Node();
                    }
                    cur = cur.dep[c - 'a'];
                }
                cur.end = true;
            }
        }

        public boolean query(char letter) {
            queries.add(letter);
            int i = queries.size() - 1;
            Node cur = head;
            while (i >= 0 && cur != null && !cur.end) {
                cur = cur.dep[queries.get(i--) - 'a'];
            }
            return cur != null && cur.end;
        }

        class Node {
            boolean end;
            Node[] dep = new Node[26];
        }
    }
}
