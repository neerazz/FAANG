# Trie (Prefix Tree)

A Trie, also known as a prefix tree, is a special tree-like data structure that is very efficient for retrieving a key in a dataset of strings. With a trie, you can search for a word or a prefix in a time complexity proportional to the length of the word, `O(L)`, where `L` is the length of the word.

Each node in the trie represents a single character of a string. A node typically contains:
*   An array or map of children nodes (e.g., 26 children for lowercase English letters).
*   A boolean flag to indicate if the node marks the end of a word.

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Insert** | O(L) | O(L * N) |
| **Search** | O(L) | O(1) |
| **Prefix Search**| O(L) | O(1) |

Where `L` is the length of the word/prefix and `N` is the number of keys.

## Problem Identification

Tries are ideal for:
*   Implementing autocomplete or search suggestions.
*   Spell checkers.
*   Problems that involve prefix matching or searching for words in a dictionary.
*   Finding the longest common prefix.

## Template: Trie Implementation

Here is a common way to implement a Trie in Java.

```java
class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // For 'a' through 'z'
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
    public void setEnd() {
        isEndOfWord = true;
    }
    public boolean isEnd() {
        return isEndOfWord;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // Helper method to search for a prefix or a whole word.
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
```

**Example Problem:** [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
*(Solution file `Trie.java` is in this directory)*
