import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 12, 2020
 * Questions: https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
        System.out.println(uniqueLetterString("ABA"));
        System.out.println(uniqueLetterString("ABCD"));
        System.out.println(uniqueLetterString("LEETCODE"));
    }

    //    https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/128952/C%2B%2BJavaPython-One-pass-O(N)
    public static int uniqueLetterString(String s) {
        int result = 0, len = s.length(), mod = 1_000_000_007;
        int[][] idxs = new int[26][2];
        for (int[] row : idxs) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i) - 'A';
            int curVal = (i - idxs[c][1]) * (idxs[c][1] - idxs[c][0]) % mod;
//            For example, if "A" appears twice at index 3, 6, 9 separately, we need to count:
//                  For the first "A": (6-3) * (3-(-1))
//                  For the second "A": (9-6) * (6-3)
//                  For the third "A": (N-9) * (9-6)
            result = (result + curVal) % mod;
            idxs[c] = new int[]{idxs[c][1], i};
        }
        for (int i = 0; i < 26; i++) {
//            This is get the third case of: len to last index of each character.
            int curVal = (len - idxs[i][1]) * (idxs[i][1] - idxs[i][0]) % mod;
//            If any character is not present then (idxs[i][1] - idxs[i][0]) equation will result in zero.
            result = (result + curVal) % mod;
        }
        return result;
    }
}
