package biweekly.biweekly50;

/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-50/problems/minimum-number-of-operations-to-make-string-sorted/
 */

public class MinimumNumberOfOperationsToMakeStringSorted {

    public static void main(String[] args) {
        System.out.println(makeStringSorted("cda") + " = 3");
        System.out.println(makeStringSorted("cdab") + " = 16");
//        System.out.println(makeStringSorted("cba") + " = 5");
//        System.out.println(makeStringSorted("aabaa") + " = 2");
//        System.out.println(makeStringSorted("cdbea") + " = 63");
//        System.out.println(makeStringSorted("leetcodeleetcodeleetcode") + " = 982157772");
    }

    public static int makeStringSorted(String s) {
        long operations = 0;
        char[] chars = s.toCharArray();
        int mod = 1_000_000_007, len = chars.length;
        int i = getI(chars, len);
        while (i > 0) {
            int j = i;
            while (j < len && chars[j] < chars[i - 1]) {
                j++;
            }
            j--; // Reduce it as J would have gone one extra.
            swap(chars, i - 1, j);
            reverse(chars, i, len);
            i = getI(chars, len);
            operations = (operations + 1) % mod;
//            System.out.println(String.valueOf(chars) + " operations = " + operations);
        }
        return (int) operations;
    }

    private static void reverse(char[] chars, int i, int len) {
        int start = i, end = len - 1;
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static int getI(char[] chars, int len) {
        for (int i = len - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) return i;
        }
        return -1;
    }
}
