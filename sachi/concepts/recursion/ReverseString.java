import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        print(reverseString(input.toCharArray()));
        print(reverseStringRecursion(input.toCharArray(), 0, input.length() - 1));
        scanner.close();
    }

    public static char[] reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
        return s;
    }

    public static char[] reverseStringRecursion(char[] s, int start, int end) {
        if (start >= end) {
            return s;
        } else {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            reverseStringRecursion(s, start + 1, end - 1);
        }
        return s;
    }

    public static void print(char[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

}