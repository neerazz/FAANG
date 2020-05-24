import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  May 22, 2020
 * Questions: https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree") + " should be [eert].");
        System.out.println(frequencySort("cccaaa") + " should be [aaaccc].");
        System.out.println(frequencySort("Aabb") + " should be [bbAa].");
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue()))
                .collect(Collectors.joining());
    }
}
