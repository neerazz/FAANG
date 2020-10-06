import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/N8vB7OVYo2D
 */

public class PermutationInAString {

    public static void main(String[] args) {
        System.out.println(findPermutation("odicf", "dc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        int[] counts = new int[26];
        boolean[] contains = new boolean[26];
        for (char c : pattern.toCharArray()) {
            counts[c - 'a']++;
            contains[c - 'a'] = true;
        }
        int i = 0;
        for (int j = 0; j < str.length(); j++) {
            if (counts[str.charAt(j) - 'a'] > 0) {
                counts[str.charAt(j) - 'a']--;
                if (j - i + 1 == pattern.length()) return true;
            } else if (i == j || !contains[str.charAt(j) - 'a']) {
                i = j + 1;
            } else if (contains[str.charAt(i) - 'a']) {
                counts[str.charAt(i) - 'a']++;
                i++;
            }
        }
        return false;
    }
}
