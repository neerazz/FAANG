import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/YQ8N2OZq0VM
 */

public class StringAnagrams {

    public static void main(String[] args) {

    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> paternMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            paternMap.put(c, paternMap.getOrDefault(c, 0) + 1);
        }
        int p1 = 0, p2 = 0, len = str.length(), found = 0;
        while (p2 < len) {
            char cur = str.charAt(p2);
            if (paternMap.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (paternMap.get(cur) == window.get(cur)) found++;
                while (p2 - p1 + 1 > pattern.length()) {
                    cur = str.charAt(p1++);
                    if (paternMap.containsKey(cur)) {
                        int count = window.remove(cur);
                        if (paternMap.get(cur) == count) found--;
                        if (count > 1) window.put(cur, count - 1);
                    }
                }
                if (found == paternMap.size()) resultIndices.add(p1);
            } else {
                p1 = p2 + 1;
                window.clear();
            }
            p2++;
        }
        return resultIndices;
    }
}
