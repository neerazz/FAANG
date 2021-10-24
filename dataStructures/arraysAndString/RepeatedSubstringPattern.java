/**
 * Created on:  Sep 03, 2020
 * Questions: https://leetcode.com/problems/repeated-substring-pattern/
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {

    }

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }

    public static boolean repeatedSubstringPattern_naive(String s) {
        int len = s.length();
        for (int l = 1; l < len; l++) {
            if (len % l == 0 && isPossible(s, l)) {
                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    private static boolean isPossible(String str, int len) {
        char[] start = new char[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            j++;
            start[i] = str.charAt(i);
        }
        while (j < str.length()) {
            for (int i = 0; i < len; i++) {
                if (str.charAt(j++) != start[i]) return false;
            }
        }
        return true;
    }
}
