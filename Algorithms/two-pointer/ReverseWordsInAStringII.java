/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * <p>
 * Given a character array s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 * <p>
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Example 2:
 * <p>
 * Input: s = ["a"]
 * Output: ["a"]
 */
public class ReverseWordsInAStringII {
    public static void main(String[] args) {

    }

    public static void reverseWords(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            swap(s, start++, end--);
        }
//         Now swap the words.
        int pre = 0, len = s.length;
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                swapRange(s, pre, i - 1);
                pre = i + 1;
            }
        }
        swapRange(s, pre, len - 1);
    }

    static void swapRange(char[] c, int from, int to) {
        if (to <= from) return;
        while (from < to) {
            swap(c, from++, to--);
        }
    }

    static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
