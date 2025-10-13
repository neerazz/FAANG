/**
 * Created on:  Jun 30, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR#problem-statement
 */

public class CharacterReplacement {

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2) + "=5");
    }

    public static int findLength(String str, int k) {
        int[] counts = new int[26];
        int len = str.length(), p1 = 0, p2 = 0, max = 0, maxCharCount = 0;
        while (p2 < len) {
            int curChar = str.charAt(p2) - 'a';
            counts[curChar]++;
            maxCharCount = Math.max(maxCharCount, counts[curChar]);
            while (p2 - p1 + 1 - maxCharCount > k) {
                counts[str.charAt(p1++) - 'a']--;
            }
            max = Math.max(max, p2 - p1 + 1);
            p2++;
        }
        return max;
    }
}
