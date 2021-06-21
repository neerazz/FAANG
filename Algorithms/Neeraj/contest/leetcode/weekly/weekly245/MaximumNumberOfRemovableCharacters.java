package weekly.weekly245;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-245/problems/maximum-number-of-removable-characters/
 */

public class MaximumNumberOfRemovableCharacters {

    public static void main(String[] args) {
//        System.out.println(maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}) + " = 1");
        System.out.println(maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}) + " = 0");
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        int[] sCounts = new int[26], pCounts = new int[26];
        populateCounts(s, sCounts);
        populateCounts(p, pCounts);
        int len = removable.length, i = 0;
        while (i < len && isSubSequence(sCounts, pCounts)) {
            int remove = removable[i++];
            sCounts[s.charAt(remove) - 'a']--;
        }
        return i - 1;
    }

    private static boolean isSubSequence(int[] sCounts, int[] pCounts) {
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] < pCounts[i]) return false;
        }
        return true;
    }

    private static void populateCounts(String str, int[] counts) {
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }
    }
}
