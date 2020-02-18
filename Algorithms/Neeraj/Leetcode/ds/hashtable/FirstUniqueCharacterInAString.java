package ds.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode") + " should be [0]");
        System.out.println(firstUniqChar("loveleetcode") + " should be [2]");
        System.out.println(firstUniqChar("aadadaad") + " should be [-1]");
    }

    public static int firstUniqChar(String s) {
        Map<Character, Indexing> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current)) {
                Indexing indexing = map.get(current);
                indexing.count++;
                map.put(current, indexing);
            } else map.put(current, new Indexing(1, i));
        }
        return map.values().stream().filter(indexing -> indexing.count == 1).mapToInt(indexing -> indexing.index).min().orElse(-1);
    }
}

class Indexing {
    int count;
    int index;

    public Indexing(int count, int index) {
        this.count = count;
        this.index = index;
    }
}