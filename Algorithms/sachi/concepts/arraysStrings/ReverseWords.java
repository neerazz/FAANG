package concepts.arraysStrings;

import java.util.Scanner;

/*
Given an input string, reverse the string word by word.

Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

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

*/
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println("[" + reverseWords(s) + "]");
        scanner.close();
    }


    private static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String[] list = s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = list.length - 1; i >= 0; i--) {
            if (!list[i].trim().isEmpty()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(" ");
                }
                sb.append(list[i].trim());
            }
        }
        return sb.toString();
    }


}