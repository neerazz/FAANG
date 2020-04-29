import java.util.HashMap;
import java.util.Map;

class Trie {

    TrieNode mainNode;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        mainNode = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Map<Character, TrieNode> myMap = mainNode.map;
        for (char c : word.toCharArray()) {
            if (!myMap.containsKey(c)) {
                TrieNode node = new TrieNode();
                myMap.put(c, node);
            }
            myMap = myMap.get(c).map;
        }
        TrieNode node = new TrieNode();
        node.isWord = true;
        myMap.put('*', node);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Map<Character, TrieNode> map = mainNode.map;
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                map = map.get(c).map;
            } else {
                return false;
            }
        }
        return map != null && map.containsKey('*');
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Map<Character, TrieNode> map = mainNode.map;
        for (char c : prefix.toCharArray()) {
            if (map.containsKey(c)) {
                map = map.get(c).map;
            } else {
                return false;
            }
        }
        return true;
    }

    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */