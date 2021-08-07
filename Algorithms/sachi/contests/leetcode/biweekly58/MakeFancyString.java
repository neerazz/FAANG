package contests.leetcode.biweekly58;

/*
https://leetcode.com/contest/biweekly-contest-58/problems/delete-characters-to-make-fancy-string/
P

A fancy string is a string where no three consecutive characters are equal.
Given a string s, delete the minimum possible number of characters from s to make it fancy.
Return the final string after the deletion. It can be shown that the answer will always be unique.

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".


Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".


Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 */
public class MakeFancyString {

    public static void main(String[] args) {

    }

    public String makeFancyString(String s) {
        if (s == null || s.length() == 2) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char prev = s.charAt(0);
        sb.append(prev);
        int repeat = 0;
        for (int i = 1; i < len; i++) {
            char curr = s.charAt(i);
            repeat = (curr == prev) ? repeat + 1 : 0;
            if (repeat < 2) {
                sb.append(curr);
            }
            prev = curr;
        }
        return sb.toString();
    }

}
