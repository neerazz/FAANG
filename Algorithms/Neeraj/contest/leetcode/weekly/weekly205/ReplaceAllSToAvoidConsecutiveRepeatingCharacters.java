package weekly.weekly205;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 */
public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {

    }

    public String modifyString(String s) {
        int len = s.length();
        int[] chars = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '?') chars[i] = -1;
            else chars[i] = s.charAt(i) - 'a';
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] < 0) {
//                Replace the -1 with a valid number between 0 to 25.
                for (int j = 0; j < 26; j++) {
                    boolean left = i == 0 || chars[i - 1] != j;
                    boolean right = i == len - 1 || chars[i + 1] != j;
                    if (left && right) {
                        chars[i] = j;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : chars) {
            sb.append((char) ('a' + num));
        }
        return sb.toString();
    }
}
