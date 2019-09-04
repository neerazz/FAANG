import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        reverseString(inputArray);
        print(inputArray);
        scanner.close();
    }

    private static void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }
        int j = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }

    private static void print(char[] input) {
        for (char c : input) {
            System.out.print(c + " ");
        }
    }
}