package concepts.arraysStrings;

import java.util.Scanner;

//TODO: KMP Algorithm
public class ImplementStrStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.nextLine();
        String needle = scanner.nextLine();
        System.out.println(strStr(haystack, needle));
        scanner.close();
    }

    public static int strStr(String haystack, String needle) {
        return 0;
    }
}