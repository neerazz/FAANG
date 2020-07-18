import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isGreaterThanOrEqual(words[i], words[i + 1], idx)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGreaterThanOrEqual(String small, String large, int[] idx) {
        int p1 = 0, p2 = 0, l1 = small.length(), l2 = large.length();
        while (p1 < l1 && p2 < l2) {
            int o1 = idx[small.charAt(p1++) - 'a'], o2 = idx[large.charAt(p2++) - 'a'];
            if (o1 > o2) return false;
        }
        return p1 == l1;
    }
}
