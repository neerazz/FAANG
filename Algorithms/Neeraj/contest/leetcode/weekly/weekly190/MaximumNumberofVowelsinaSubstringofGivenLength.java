package weekly.weekly190;

/**
 * Created on:  May 23, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 */
public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {

    }

    public static int maxVowels(String s, int k) {
        int max = 0;
//        Advance the s with k-1.
        int p1 = 0, p2 = 0, sum = 0;
        while (p2 < k - 1) {
            sum += isVowel(s.charAt(p2++)) ? 1 : 0;
            max = Math.max(max, sum);
        }
        while (p2 < s.length()) {
            sum += isVowel(s.charAt(p2++)) ? 1 : 0;
            max = Math.max(max, sum);
            sum -= isVowel(s.charAt(p1++)) ? 1 : 0;
        }
        return max;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
