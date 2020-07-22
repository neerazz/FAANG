import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Jul 20, 2020
 * Questions: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> op = new ArrayList<>();
        if (p.length() > s.length()) return op;
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int start = 0, end = 0;
        while (end < s.length()) {
            char cur = s.charAt(end);
            if (count[cur - 'a'] > 0) {
                count[cur - 'a']--;
                end++;
                if (end - start == p.length()) {
                    op.add(start);
                }
            } else if (start == end) {
                start++;
                end++;
            } else {
                count[s.charAt(start++) - 'a']++;
            }
        }
        return op;
    }
}
