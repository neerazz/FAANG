import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class SherlockAndAnagrams {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams_wrong("abba") + " should be [4]");
        System.out.println(sherlockAndAnagrams_wrong("abcd") + " should be [0]");
        System.out.println(sherlockAndAnagrams_wrong("ifailuhkqq") + " should be [3]");
        System.out.println(sherlockAndAnagrams_wrong("kkkk") + " should be [10]");
        System.out.println(sherlockAndAnagrams_wrong("cdcd") + " should be [5]");
        System.out.println(sherlockAndAnagrams("abba") + " should be [4]");
        System.out.println(sherlockAndAnagrams("abcd") + " should be [0]");
        System.out.println(sherlockAndAnagrams("ifailuhkqq") + " should be [3]");
        System.out.println(sherlockAndAnagrams("kkkk") + " should be [10]");
        System.out.println(sherlockAndAnagrams("cdcd") + " should be [5]");
    }

    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        // Keep track of how many anagrams we've seen
        int totalCount = 0;
        // Generate all substrings (N^2)
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentSubString = s.substring(i, j);
                // Sort all strings E.g. ab & ba both == ab now
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);
                // If sorted substring has been seen before
                // Check how many times we've seen it and add that amount to the count
                totalCount += map.getOrDefault(currentSubString, 0);
                map.put(currentSubString, map.getOrDefault(currentSubString, 0) + 1);
            }
        }
        return totalCount;
    }

    static int sherlockAndAnagrams_wrong(String s) {
        Map<String, Integer> map = new HashMap<>();

        String input = "";
        for (int i = 0; i < s.length(); i++) {
            input = input + s.charAt(i);
            map.put(input, map.getOrDefault(input, 0) + 1);
            StringBuilder stringBuilder = new StringBuilder(input);
            String reverse = stringBuilder.reverse().toString();
            map.put(reverse, map.getOrDefault(reverse, 0) + 1);
            for (int j = 1; j < input.length() - 1; j++) {
                String cur = input.substring(j);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                StringBuilder stringBuilder2 = new StringBuilder(cur);
                String reverse2 = stringBuilder2.reverse().toString();
                map.put(reverse2, map.getOrDefault(reverse2, 0) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder(entry.getKey());
            String reverse = sb.reverse().toString();
            if (map.containsKey(reverse)) {
                count += map.get(reverse);
                System.out.println("Actual : " + entry.getKey() + " reverse : " + reverse);
            }
        }
        return count;
    }
}
