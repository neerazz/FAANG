package problems.arraysAndString;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
Given an input string, reverse the string word by word.
Example 1:
Input: "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println("Answer is: [" + reverseWords("the sky is blue") + "] should be [blue is sky the]");
        System.out.println("Answer is: [" + reverseWords("  hello world!  ") + "] should be [world! hello]");
        System.out.println("Answer is: [" + reverseWords("a good   example") + "] should be [example good a]");
    }

    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        int start = 0, end = split.length - 1;
        while (start <= end) {
            String temp = split[start];
            split[start] = split[end];
            start++;
            split[end] = temp;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(split).filter(str -> !str.isEmpty()).forEach(str -> sb.append(str).append(" "));
        return sb.toString().trim();
    }
}
