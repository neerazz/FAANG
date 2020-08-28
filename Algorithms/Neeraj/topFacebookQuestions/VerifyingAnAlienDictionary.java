import java.util.Arrays;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
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

    private static boolean isGreaterThanOrEqual(String first, String second, int[] index) {
        System.out.println("first = " + first + ", second = " + second + ", index = " + Arrays.toString(index));
        int p1 = 0, p2 = 0, l1 = first.length(), l2 = second.length();
        while (p1 < l1 && p2 < l2) {
            int o1 = index[first.charAt(p1++) - 'a'], o2 = index[second.charAt(p2++) - 'a'];
            if (o1 < o2) return true;
            if (o1 > o2) return false;
        }
        return p1 == l1;
    }
}
