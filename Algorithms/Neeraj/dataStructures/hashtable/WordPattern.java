import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 07, 2020
 * Questions: https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {
    public static void main(String[] args) {

    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] split = str.split(" ");
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < split.length; i++) {
            char pat = pattern.charAt(i);
            String word = split[i];
            map1.putIfAbsent(pat, i);
            map2.putIfAbsent(word, i);
            if (!map1.get(pat).equals(map2.get(word))) return false;
        }
        return true;
    }
}
