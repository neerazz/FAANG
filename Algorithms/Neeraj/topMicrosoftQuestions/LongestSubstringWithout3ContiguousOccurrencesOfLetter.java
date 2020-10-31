import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/398031/
 */

public class LongestSubstringWithout3ContiguousOccurrencesOfLetter {

    public static void main(String[] args) {
        System.out.println(longestSubString("aabbaaaaabb"));
        System.out.println(longestSubString("aabbaabbaabbaa"));
    }

    private static String longestSubString(String str) {
        int[] results = {0, 0, 0};
        int p1 = 0, p2 = 0, len = str.length();
        int count = 0;
        while (p2 < len) {
            if (p2 > 0 && str.charAt(p2) == str.charAt(p2 - 1)) {
//                if we met two the same, letters increase the counter of the same letters
                count++;
            } else {
//                if next letter is different drop the counter to 1
                count = 1;
            }
            if (count > 2) {
//                Bring the p1 pointer to p2-1;
                p1 = p2 - 1;
            } else if (p2 - p1 > results[0]) {
                results[0] = p2 - p1;
                results[1] = p1;
                results[2] = p2;
            }
            p2++;
        }
        return str.substring(results[1], results[2] + 1);
    }
}
