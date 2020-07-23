/**
 * Created on:  Jul 20, 2020
 * Questions: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class AddAndSearchWordDataStructureDesign {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad") + " [false]");
        System.out.println(wordDictionary.search("bad") + " [true]");
        System.out.println(wordDictionary.search(".ad") + " [true]");
        System.out.println(wordDictionary.search("b..") + " [true]");
        System.out.println(wordDictionary.search("..") + " [false]");
    }

    static class WordDictionary {

        Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Trie pre = trie;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (pre.next[c - 'a'] == null) {
                    pre.next[c - 'a'] = new Trie();
                }
                pre = pre.next[c - 'a'];
            }
            pre.end = true;
        }

        public boolean search(String word) {
            if (word.length() == 0) return true;
            return search(word, 0, trie);
        }

        public boolean search(String word, int idx, Trie trie) {
            if (trie == null) return false;
            if (idx == word.length()) return trie.end;
            char cur = word.charAt(idx);
            if (cur != '.') return search(word, idx + 1, trie.next[cur - 'a']);
            for (int i = 0; i < 26; i++) {
                if (search(word, idx + 1, trie.next[i])) {
                    return true;
                }
            }
            return false;
        }

        class Trie {
            Trie[] next;
            boolean end;

            Trie() {
                this.next = new Trie[26];
                this.end = false;
            }
        }
    }
}
