import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
 */

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {

    }

    public static int minDeletions(String s) {
        int[] counts = new int[26];
        for (char cur : s.toCharArray()) {
            counts[cur - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int del = 0;
        for (int count : counts) {
            if (count == 0) continue;
            while (set.contains(count) && count > 0) {
                count--;
                del++;
            }
            set.add(count);
        }
        return del;
    }
}
