import java.util.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/370112/
 */

public class SubstringsOfSizeKWithKDistinctChars {

    public static void main(String[] args) {
        System.out.println(uniqueSubstringSizeK("abcabc", 3) + "\n[\"abc\", \"bca\", \"cab\"]");
        System.out.println(uniqueSubstringSizeK("abacab", 3) + "\n[\"bac\", \"cab\"]");
        System.out.println(uniqueSubstringSizeK("awaglknagawunagwkwagl", 4) + "\n[\"wagl\", \"aglk\", \"glkn\", \"lkna\", \"knag\", \"gawu\", \"awun\", \"wuna\", \"unag\", \"nagw\", \"agwk\", \"kwag\"]");
    }

    private static List<String> uniqueSubstringSizeK(String str, int k) {
        Set<Character> window = new HashSet<>();
        LinkedHashSet<String> result = new LinkedHashSet<>();
        int p1 = 0, p2 = 0, len = str.length();
        while (p2 < len) {
            char cur = str.charAt(p2);
            while (window.contains(cur) || window.size() >= k) {
                window.remove(str.charAt(p1++));
            }
            window.add(cur);
            if (window.size() == k) {
                result.add(str.substring(p1, p2 + 1));
            }
            p2++;
        }
        return new ArrayList<>(result);
    }
}
