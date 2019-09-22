package trie;

import java.util.*;

/*
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1052/
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWordDataStructureDesign {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad") + " -> false");
        System.out.println(obj.search("bad") + " -> true");
        System.out.println(obj.search(".ad") + " -> true");
        System.out.println(obj.search("b..") + " -> true");
    }
}

class WordDictionary {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (node.children.get(current) == null) {
                node.children.put(current, new Node());
            }
            node = node.children.get(current);
            node.lengths.add(word.length());
        }
        node.lengths.add(word.length());
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(Node root, String word, int index) {
        if (index == word.length()) return root.isEnd;
        if (word.charAt(index) == '.') {
            for (Node child : root.children.values()) {
                if (child.lengths.contains(word.length())) {
                    if (searchHelper(child, word, index + 1)) return true;
                }
            }
            return false;
        }
        Node child = root.children.get(word.charAt(index));
        return child != null && searchHelper(child, word, index + 1);
    }

    class Node {
        Map<Character, Node> children = new HashMap<>();
        Set<Integer> lengths = new HashSet<>();
        boolean isEnd = false;
    }
}

class WordDictionary_BruteForce {

    List<String> strings;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary_BruteForce() {
        strings = new ArrayList<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        strings.add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return strings.stream().anyMatch(w -> compare(w, word));
    }

    private boolean compare(String word, String search) {
        if (word.length() != search.length()) return false;
        int index = 0;
        while (index < search.length()) {
            if (search.charAt(index) != '.') {
                if (search.charAt(index) != word.charAt(index)) return false;
            }
            index++;
        }
        return true;
    }
}