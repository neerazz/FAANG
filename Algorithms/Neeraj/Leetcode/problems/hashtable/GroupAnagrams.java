package problems.hashtable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/
Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).map(s -> new Group(s, sortString(s)))
                .collect(Collectors.groupingBy(g -> g.sortedString))
                .values().stream().map(groups -> groups.stream().map(g -> g.actualString)
                        .collect(Collectors.toList())).collect(Collectors.toList());
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}

class Group {
    String actualString;
    String sortedString;

    public Group(String actualString, String sortedString) {
        this.actualString = actualString;
        this.sortedString = sortedString;
    }
}