package trie;

import java.util.*;

/*
https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1138/
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
Example 1:
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {
    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}) + " should be [[0,1],[1,0],[3,2],[2,4]].");
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        TrieNode trieNode = new TrieNode();
        Arrays.stream(words).forEach(w -> insertIntoNode(trieNode, w));
        return null;
    }

    private static void insertIntoNode(TrieNode trieNode, String word) {
        TrieNode root = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (root.map.containsKey(current)) {
                root = root.map.get(current);
            } else {
                root.map.put(current, new TrieNode());
            }
            root.bottomUpValue = String.format("%s%s", current, root.bottomUpValue);
        }
    }

    private static boolean isPalindrome(String[] words, int i, int j) {
        int m = 0;
        int n = words[j].length() - 1;
        while (m < words[i].length() && n >= 0) {
            if (words[i].charAt(m) != words[j].charAt(n)) return false;
            m++;
            n--;
        }
        int m2 = words[i].length() - 1;
        while (m < m2) {
            if (words[i].charAt(m) != words[i].charAt(m2)) return false;
            m++;
            m2--;
        }
        int n2 = 0;
        while (n > n2) {
            if (words[j].charAt(n) != words[j].charAt(n2)) return false;
            n--;
            n2++;
        }
        return true;
    }

    public static List<List<Integer>> palindromePairs_Naive(String[] words) {
        List<List<Integer>> output = new ArrayList<>();
        if (words.length < 2) return output;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words, i, j)) output.add(Arrays.asList(i, j));
                if (isPalindrome(words, j, i)) output.add(Arrays.asList(j, i));
//                if (isPalindrome(words[i] + words[j])) output.add(Arrays.asList(i, j));
//                if (isPalindrome(words[j] + words[i])) output.add(Arrays.asList(j, i));
            }
        }
        return output;
    }

    private static boolean isPalindrome(String string) {
        int start = 0, end = string.length() - 1;
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        String bottomUpValue = "";
    }
}