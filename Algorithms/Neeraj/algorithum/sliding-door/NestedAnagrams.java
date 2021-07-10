import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jul 10, 2021
 * Ref:
 */

public class NestedAnagrams {

    public static void main(String[] args) {
        System.out.println(nestedAnagrams("bored cat", "act robed") + " = true");
        System.out.println(nestedAnagrams("aa bb", "ab ab") + " = false");
    }

    static boolean nestedAnagrams(String s, String t) {
//        Map<String, Integer> map1 = buildMap(s);
//        Map<String, Integer> map2 = buildMap(t);
        Map<String, Integer> map1 = buildMap_2(s);
        Map<String, Integer> map2 = buildMap_2(t);
        for (String word : map2.keySet()) {
//            The word in map2 should be present in map1.
            if (!map1.containsKey(word)) return false;
//            The word in map2 should be present exactly same number of times in map1.
            if (map1.get(word).equals(map2.get(word))) {
//                If so remove the word in map1.
                map1.remove(word);
            } else {
                return false;
            }
        }
//        If all the words in t, are present in s and vice-Versa then the map1 should be empty.
        return map1.isEmpty();
    }

    private static Map<String, Integer> buildMap_2(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = str.split(" ");
        for (String word : split) {
            String sorted = sort(word);
            map.put(sorted, map.getOrDefault(sorted, 0) + 1);
        }
        return map;
    }

    private static Map<String, Integer> buildMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char cur : str.toCharArray()) {
            if (cur == ' ') {
                String string = sort(sb.toString());
                map.put(string, map.getOrDefault(string, 0) + 1);
                sb = new StringBuilder();
            } else {
                sb.append(cur);
            }
        }
        String string = sort(sb.toString());
        map.put(string, map.getOrDefault(string, 0) + 1);
        return map;
    }

    private static String sort(String str) {
        int[] counts = new int[26];
        for (char cur : str.toCharArray()) {
            counts[cur - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int count = counts[i];
            if (count == 0) continue;
            while (count-- > 0) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
