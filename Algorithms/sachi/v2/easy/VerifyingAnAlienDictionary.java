package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1],
 * hence the sequence is unsorted.
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {

        //Second
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));

        //First
        words = new String[]{"word", "world", "row"};
        order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words, order));

        //Third
        words = new String[]{"apple", "app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }


    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        //Build a map
        int i = 0;
        for (char c : order.toCharArray()) {
            map.put(c, i++);
        }
        //Compare w[i] with w[i+1] each word
        for (i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (!isFirstWordSmaller(map, w1, w2)) return false;
        }
        return true;
    }

    public static boolean isFirstWordSmaller(Map<Character, Integer> map, String w1, String w2) {
        int max = Math.max(w1.length(), w2.length());
        for (int i = 0; i < max; i++) {
            if (i >= w1.length()) return true;
            if (i >= w2.length()) return false;
            int w1C = map.get(w1.charAt(i));
            int w2C = map.get(w2.charAt(i));
            if (w1C > w2C) {
                return false;
            } else if (w1C < w2C) {
                return true;
            }
        }
        return true;
    }
}
