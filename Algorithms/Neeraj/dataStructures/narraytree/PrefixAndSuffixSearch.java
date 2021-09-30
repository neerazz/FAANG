import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Sep 29, 2021
 * Ref: https://leetcode.com/problems/prefix-and-suffix-search/
 */
public class PrefixAndSuffixSearch {
    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        System.out.println(wordFilter.f("a", "e"));
    }
}

class WordFilter {

    Node n1, n2;
    String[] words;

    public WordFilter(String[] words) {
        n1 = new Node(' ');
        n2 = new Node(' ');
        for (int i = 0; i < words.length; i++) {
            buildNode(words[i], i, n1);
            buildNode(reverse(words[i]), i, n2);
        }
        this.words = words;
    }

    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    void buildNode(String word, int idx, Node node) {
        Node cur = node;
        cur.addWord(idx);
        for (char c : word.toCharArray()) {
            if (cur.deps[c - 'a'] == null) {
                cur.deps[c - 'a'] = new Node(c);
            }
            Node next = cur.deps[c - 'a'];
            cur = next;
            cur.addWord(idx);
        }
    }

    Node getNode(String word, Node node) {
        Node cur = node;
        for (char c : word.toCharArray()) {
            cur = cur.deps[c - 'a'];
            if (cur == null) break;
        }
        return cur;
    }

    public int f(String prefix, String suffix) {
        Node r1 = getNode(prefix, n1);
        Node r2 = getNode(reverse(suffix), n2);
        if (r1 == null || r2 == null) return -1;
        return getIdx(r1, r2);
    }

    int getIdx(Node n1, Node n2) {
//         Lop through the smallest map, and check teh otehr map.
        if (n1.words.size() > n1.words.size()) return getIdx(n2, n1);
        int result = -1;
        Set<Integer> m1 = n1.words;
        Set<Integer> m2 = n2.words;
        for (int idx : m1) {
            if (m2.contains(idx)) {
                if (result == -1 || result < idx) result = idx;
            }
        }
        return result;
    }

    class Node {
        char c;
        Node[] deps = new Node[26];
        Set<Integer> words = new HashSet<>();

        Node(char cur) {
            this.c = cur;
        }

        void addWord(int idx) {
            words.add(idx);
        }
    }
}