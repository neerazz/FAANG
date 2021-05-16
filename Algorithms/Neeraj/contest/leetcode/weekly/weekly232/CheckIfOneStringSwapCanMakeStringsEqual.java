package weekly.weekly232;

import java.util.*;

/**
 * Created on:  Mar 13, 2021
 * Questions:
 */

public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
    }

    public static boolean areAlmostEqual_rev1(String s1, String s2) {
        int n = s1.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            f[s1.charAt(i) - 'a']++;
            f[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) return false;
        }

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }
        return diff.size() <= 2;
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        boolean swapped = false;
        int b = -1, len = s1.length();
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 == c2 || i == b) continue;
            if (swapped) return false;
            int j = i + 1;
            while (j < len && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }
            if (j < len && c1 == s2.charAt(j) && c2 == s1.charAt(j)) {
                swapped = true;
                b = j;
            } else return false;
        }
        return true;
    }
}
