import java.util.Scanner;

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 */
public class ReverseString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(reverseWords(s));
        scanner.close();
    }

    private static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] list = s.split(" ");
        for (String str : list) {
            sb.append(new StringBuilder(str).reverse()).append(" ");
        }
        return sb.toString().trim();
    }

}
