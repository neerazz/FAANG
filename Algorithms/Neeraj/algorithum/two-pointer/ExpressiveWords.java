/**
 * Created on:  Sep 23, 2021
 * Ref: https://leetcode.com/problems/expressive-words/
 */
public class ExpressiveWords {
    public static void main(String[] args) {

    }

    public int expressiveWords(String S, String[] words) {
        if (S == null || words == null) {
            return 0;
        }
        int count = 0;
        for (String word : words) {
            if (stretchy(S, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean stretchy(String S, String word) {
        if (word == null) return false;
        int i = 0, j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(S, i);
                int len2 = getRepeatedLength(word, j);
//                If the repeated in first string is less than 3, then it should match the other repeated char count.
                if (len1 < 3 && len1 != len2) return false;
//                If the repeated length is greater than 3 in first string, then only that should be greater.
                if (len1 >= 3 && len1 < len2) return false;
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }

    public int getRepeatedLength(String str, int i) {
        int j = i;
        while (j < str.length() && str.charAt(j) == str.charAt(i)) {
            j++;
        }
        return j - i;
    }
}
