package strings;

import java.util.*;


/*
https://leetcode.com/problems/group-anagrams/
P

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.


Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]


 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }

    //Insight - Sort the arrays and use the sorted String as a key.
    //There is no String sort function in Java
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            List<String> list = map.get(sorted);
            if (list == null) list = new ArrayList<>();
            list.add(str);
            map.put(sorted, list);
        }
        return new ArrayList<>(map.values());
    }

    //Create Hashes like this - a#1b#2
    //Use them as keys
    public List<List<String>> groupAnagramsElegant(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = computeHash(str);
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            map.put(hash, list);
        }
        return new ArrayList<>(map.values());
    }

    //a#1b#2
    public String computeHash(String s) {
        StringBuilder sb = new StringBuilder();
        char[] carr = new char[26];
        for (Character c : s.toCharArray()) {
            carr[c - 'a']++;
        }
        for (int i = 0; i < carr.length; i++) {
            if (carr[i] != 0) {
                char c = (char) ('a' + i);
                sb.append(c).append("#").append(carr[i]);
            }
        }
        return sb.toString();
    }
}
