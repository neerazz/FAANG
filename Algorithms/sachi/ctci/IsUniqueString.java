package ctci;

import util.Util;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUniqueString {

    public static void main(String[] args) {
        test();
    }

    //Sol 1 - Simple count using an Array O(n)
    private static boolean isUniqueString1(String str) {
        if (str.length() > 128) return false;
        boolean[] arr = new boolean[128]; //Since ASCII we are using 128 bits
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (arr[val]) return false;
            arr[val] = true;
        }
        return true;
    }

    //Sol 2 -  Using bitwise operator - O(1)
    private static boolean isUniqueString2(String str) {
        return false;
    }

    //Sol 3 - Sorting - O(nlog(n))
    private static boolean isUniqueString3(String str) {
        if (str.length() > 128) return false;
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1]) return false;
        }
        return true;
    }

    private static void test() {
        while (true) {
            String str = Util.generateRandomString(10);
            boolean first = isUniqueString1(str);
            boolean second = isUniqueString3(str);
            if (first != second) {
                System.out.println("Failed for input - " + str);
                break;
            } else {
                System.out.println("Good for String: " + str);
            }

        }
    }


}
