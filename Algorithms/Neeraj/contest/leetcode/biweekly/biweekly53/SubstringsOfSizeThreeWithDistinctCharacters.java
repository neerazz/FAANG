package biweekly.biweekly53;

/**
 * Created on:  May 29, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-53/problems/substrings-of-size-three-with-distinct-characters/
 */

public class SubstringsOfSizeThreeWithDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz") + " = 1");
        System.out.println(countGoodSubstrings("aababcabc") + " = 4");
    }

    public static int countGoodSubstrings(String s) {
        int len = s.length(), count = 0;
        for (int i = 0; i < len; i++) {
            int[] counts = new int[26];
            int chars = 0;
            for (int j = i; j < len && j < i + 3; j++) {
                counts[s.charAt(j) - 'a']++;
                chars++;
            }
            if (chars == 3 && isUnique(counts)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isUnique(int[] counts) {
        for (int count : counts) {
            if (count > 1) return false;
        }
        return true;
    }
}
