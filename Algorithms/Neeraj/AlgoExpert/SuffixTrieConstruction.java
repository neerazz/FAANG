import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 18, 2020
 * Questions: https://www.algoexpert.io/questions/Suffix%20Trie%20Construction
 */
public class SuffixTrieConstruction {
    public static void main(String[] args) {
        SuffixTrie suffixTrie = new SuffixTrie("babc");
        System.out.println(suffixTrie.contains("abc"));
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                helper(str.substring(i));
            }
        }

        public void helper(String str) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.children.put(endSymbol, null);
        }

        public boolean contains(String str) {
            if (str.length() == 0) return false;
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                if (node.children.containsKey(c)) node = node.children.get(c);
                else return false;
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
