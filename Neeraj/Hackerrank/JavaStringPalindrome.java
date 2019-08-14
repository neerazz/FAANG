import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-string-reverse/problem?h_r=next-challenge&h_v=zen
 */
public class JavaStringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(isPalindrome(input) ? "Yes" : "No");
    }

    private static boolean isPalindrome(String input) {
        if (input.isEmpty()) return false;
        if (input.length() == 1) return true;
        int start = 0, end = input.length() - 1;
        while (start <= end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
