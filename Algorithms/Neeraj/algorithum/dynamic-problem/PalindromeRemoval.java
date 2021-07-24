import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jul 21, 2021
 * Ref : https://leetcode.com/problems/palindrome-removal/
 */
public class PalindromeRemoval {

    public static void main(String[] args) {
        System.out.println(minimumMoves(Arrays.asList()));
    }

    private static int minimumMoves(List<String> arr) {
        return solve(arr, 0, "");
    }

    private static int solve(List<String> arr, int start, String s) {
        int max = 0;
        for (int i = start; i < arr.size(); i++) {
            String a = arr.get(i);
            if (isDifferent(a, s)) max = Math.max(max, a.length() + solve(arr, i + 1, s + a));
        }
        return max;
    }

    private static boolean isDifferent(String a, String b) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < a.length(); i++) freq1[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++) freq2[b.charAt(i) - 'a']++;
        for (int i = 0; i < 26; i++) if (freq1[i] > 1 || freq2[i] > 1 || (freq1[i] != 0 && freq2[i] != 0)) return false;
        return true;
    }
}
