package BasicProgramming.InputOutput;

import java.util.Scanner;

public class PalindromicString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(isPalindrome(s.nextLine()));
    }

    private static String isPalindrome(String input) {
        if (input == null || input.isEmpty()) return "NO";
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--)) {
                return "NO";
            }
        }
        return "YES";
    }
}
