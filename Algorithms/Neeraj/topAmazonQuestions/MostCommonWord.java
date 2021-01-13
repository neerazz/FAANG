import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/most-common-word/
 */

public class MostCommonWord {

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        System.out.println(mostCommonWord("Bob", new String[]{}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int max = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            char cur = paragraph.charAt(i);
            if (cur == ' ' || cur == '!' || cur == '?' || cur == '\'' || cur == ',' || cur == ';' || cur == '.') {
                if (sb.length() == 0) continue;
                String word = sb.toString();
                sb = new StringBuilder();
                if(set.contains(word)) continue;
                int count = map.getOrDefault(word, 0);
                map.put(word, count + 1);
                if (count + 1 > max) {
                    result = word;
                    max = count + 1;
                }
            } else {
                sb.append(Character.toLowerCase(cur));
            }
        }
        String word = sb.toString();
        int count = map.getOrDefault(word, 0);
        map.put(word, count + 1);
        if (count + 1 > max) {
            result = word;
        }
        return result;
    }
}
