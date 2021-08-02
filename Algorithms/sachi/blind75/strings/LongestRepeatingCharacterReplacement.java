package blind75.strings;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/
F

You are given a string s and an integer k. You can choose any character of the string and change it to any
other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after
performing the above operations.


Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        //TODO: Implement this
    }

    //Insight: Your window will be invalid. But we only shrink everytime there is no valid input.
    public static int characterReplacement(String s, int k) {
        //Longest substring with at most K+1 diff chars
        return 0;
    }
}
