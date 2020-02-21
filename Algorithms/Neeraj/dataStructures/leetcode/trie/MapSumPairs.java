package ds.trie;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058/
Implement a MapSum class with insert, and sum methods.
For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */
public class MapSumPairs {
    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap") + " should be [3].");
        obj.insert("ap", 2);
        System.out.println(obj.sum("ap") + " should be [5].");
        System.out.println("=================================");
        MapSum_Elegent mapSumElegent = new MapSum_Elegent();
        mapSumElegent.insert("apple", 3);
        System.out.println(mapSumElegent.sum("ap") + " should be [3].");
        mapSumElegent.insert("ap", 2);
        System.out.println(mapSumElegent.sum("ap") + " should be [5].");
    }
}

class MapSum_Elegent {

    TrieNode trieNode;

    /**
     * Initialize your data structure here.
     */
    public MapSum_Elegent() {
        trieNode = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = trieNode;
        int currentValue = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.children.get(c) == null) {
                // insert a new node if the path does not exist
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            currentValue += cur.currentValue;
        }
        cur.currentValue = val;
    }

    public int sum(String prefix) {
        return findSum(findPrefixTrie(prefix));
    }

    private int findSum(TrieNode prefixTrie) {
        if (prefixTrie == null) return 0;
        int sum = prefixTrie.currentValue;
        for (Map.Entry<Character, TrieNode> entry : prefixTrie.children.entrySet()) {
            sum += findSum(entry.getValue());
        }
        return sum;
    }

    private TrieNode findPrefixTrie(String prefix) {
        TrieNode curent = trieNode;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode trieNode = curent.children.get(prefix.charAt(i));
            if (trieNode != null) {
                curent = trieNode;
            } else {
                return null;
            }
        }
        return curent;
    }

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        int currentValue;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + children +
                    ", currentValue=" + currentValue +
                    '}';
        }
    }
}

class MapSum {

    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        return map.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getKey().startsWith(prefix)).mapToInt(Map.Entry::getValue).sum();
    }
}