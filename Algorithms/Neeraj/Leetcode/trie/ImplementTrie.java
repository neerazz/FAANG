package trie;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/learn/card/trie/147/basic-operations/1047/
Implement a trie with insert, search, and startsWith methods.
Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple") + " should be [true].");   // returns true
        System.out.println(trie.search("app") + " should be [false].");     // returns false
        System.out.println(trie.startsWith("app") + " should be [true]."); // returns true
        trie.insert("app");
        System.out.println(trie.search("app") + " should be [true].");     // returns true

    }
}

class Trie_Array {
    Trie[] arr;
    boolean end;

    /**
     * Initialize your data structure here.
     */
    public Trie_Array() {
        arr = new Trie[26];
        end = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0) {
            this.end = true;
            return;
        }
        if (this.arr[word.charAt(0) - 'a'] == null) {
            this.arr[word.charAt(0) - 'a'] = new Trie();
        }
        this.arr[word.charAt(0) - 'a'].insert(word.substring(1));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0) {
            return this.end;
        }
        if (this.arr[word.charAt(0) - 'a'] == null) {
            return false;
        }
        return this.arr[word.charAt(0) - 'a'].search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        if (word.length() == 0) {
            return true;
        }
        if (this.arr[word.charAt(0) - 'a'] == null) {
            System.out.println(word.charAt(0));
            return false;
        }
        return this.arr[word.charAt(0) - 'a'].startsWith(word.substring(1));
    }
}

class Trie {
    TrieNode trieNode;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        trieNode = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.get(c) == null) {
                // insert a new node if the path does not exist
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
    }

    public void insert_recursive(String word) {
        trieNode = insertHelper(trieNode, word);
    }

    private TrieNode insertHelper(TrieNode trieNode, String word) {
        if (word.isEmpty()) return trieNode;
        char current = word.charAt(0);
        if (word.length() == 1) {
//            If only one word is left out then add it as a child to the current tree.
            trieNode.children.put(current, new TrieNode());
            return trieNode;
        }
        for (Map.Entry<Character, TrieNode> e : trieNode.children.entrySet()) {
            if (current == e.getKey()) {
                trieNode.children.put(e.getKey(), insertHelper(e.getValue(), word.substring(1)));
                return trieNode;
            }
        }
//        Reached the end of the tree.
        TrieNode children = createChildren(trieNode.parentChars, word.substring(1));
        trieNode.children.put(current, children);
        return trieNode;
    }

    private TrieNode createChildren(String parentChars, String substring) {
        TrieNode trieNode = new TrieNode();
        trieNode.parentChars = parentChars;
        char current = substring.charAt(0);
        if (substring.length() > 1) {
            String currentParentChar = parentChars != null ? parentChars + current : String.valueOf(current);
            trieNode.children.put(current, createChildren(currentParentChar, substring.substring(1)));
        } else {
            trieNode.children.put(current, new TrieNode());
        }
        return trieNode;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode1 = search(trieNode, word);
        return trieNode1 != null && trieNode1.children.isEmpty();
    }

    private TrieNode search(TrieNode trieNode, String word) {
        if (trieNode == null || word.isEmpty()) return trieNode;
        char current = word.charAt(0);
        if (trieNode.children.containsKey(current)) return search(trieNode.children.get(current), word.substring(1));
        else return null;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode1 = search(trieNode, prefix);
        return trieNode1 != null;
    }

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        String parentChars = null;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", parentChars='" + parentChars + '\'' +
                    '}';
        }
    }
}