package biweekly.biweekly21;

import java.util.*;

class FindtheLongestSubstringContainingVowel {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }

    public static int findTheLongestSubstring(String s) {
        if (s == null) return 0;
        Set<Integer> integerSet = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Map<Character, Integer> map = new HashMap<>();
            char charAtI = s.charAt(i);
            if (isVowel(charAtI)) {
                map.put(charAtI, 1);
            }
            if (hasEvenVowels(map)) {
                integerSet.add(1);
            }
            for (int j = i + 1; j < len; j++) {
                char charAtJ = s.charAt(j);
                if (isVowel(charAtJ)) {
                    map.put(charAtJ, map.getOrDefault(charAtJ, 0) + 1);
                }
                if (hasEvenVowels(map)) {
                    String substring = s.substring(i, j + 1);
//                    System.out.println("Value at : " + s.substring(i,j+1) + map);
                    integerSet.add(substring.length());
                }
            }
        }
//        System.out.println(integerSet);
        int max = 0;
        for (int i : integerSet) {
            max = Math.max(max, i);
        }
//        System.out.println(integerSet);
        return max;
    }

    private static boolean hasEvenVowels(Map<Character, Integer> map) {
        return map.getOrDefault('a', 0) % 2 == 0 && map.getOrDefault('e', 0) % 2 == 0 && map.getOrDefault('i', 0) % 2 == 0 && map.getOrDefault('o', 0) % 2 == 0 && map.getOrDefault('u', 0) % 2 == 0;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
