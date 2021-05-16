package biweekly.biweekly23;

import java.util.HashMap;
import java.util.Map;

/**
 * Crated on:  Apr 04, 2020
 */
public class ConstructKPalindromeStrings {
    public static void main(String[] args) {
        System.out.println(canConstruct_optimal("yzyzyzyzyzyzyzy", 2));
    }

    //        Return false, when:
//              the string length is less then K,
//              string is null,
//              if the odd char occurrence is more then k. Because you can have at max K odd char.
//                      Even number of occurrence + one odd occurrence is required to make a string palindrome.
    public static boolean canConstruct_optimal(String s, int k) {
        if (s.length() < k) return false;
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        int oddCount = 0;
        for (int count : chars) {
            oddCount += count % 2;
        }
        return oddCount <= k;
    }

    public static boolean canConstruct_withMap(String s, int k) {
        if (s.length() < k) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) oddCount++;
        }
        return oddCount <= k;
    }
}
