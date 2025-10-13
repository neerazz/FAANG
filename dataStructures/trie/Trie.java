class TrieNode {
    // Array to store links to child nodes. Size 26 for 'a' through 'z'.
    private TrieNode[] children;
    // Flag to mark if this node represents the end of a word.
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }

    // Checks if a child corresponding to the character exists.
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    // Returns the child node corresponding to the character.
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    // Sets a child node for the given character.
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    // Marks this node as the end of a word.
    public void setEnd() {
        isEndOfWord = true;
    }

    // Checks if this node is the end of a word.
    public boolean isEnd() {
        return isEndOfWord;
    }
}

public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        // The word exists only if the node is found and it's marked as the end of a word.
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // A prefix exists if we can trace it to a node, regardless of whether it's an end of a word.
        return searchPrefix(prefix) != null;
    }

    // Helper method to search for a prefix or a whole word.
    // Returns the node at the end of the word/prefix, or null if not found.
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
