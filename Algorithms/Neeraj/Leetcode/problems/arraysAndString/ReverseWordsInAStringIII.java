package problems.arraysAndString;

import java.util.Arrays;

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println("Answer is: \t[" + reverseWords("Let's take LeetCode contest") + "] \nShould be: \t[s'teL ekat edoCteeL tsetnoc]");
    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strings).forEach(str -> {
            char[] chars = str.toCharArray();
            reverse(chars, 0, chars.length - 1);
            sb.append(String.valueOf(chars)).append(" ");
        });
        return sb.toString().trim();
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            j--;
            i++;
        }
    }
}
