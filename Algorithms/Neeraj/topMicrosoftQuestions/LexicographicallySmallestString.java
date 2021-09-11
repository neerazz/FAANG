/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/366869/
 */

public class LexicographicallySmallestString {

    public static void main(String[] args) {
        System.out.println(smallestString("abczd"));
        System.out.println(smallestString_optimal("abczd"));
    }

    private static String smallestString_optimal(String str) {
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return str.substring(0, i) + str.substring(i + 1);
            }
        }
        return str.substring(0, len - 1);
    }

    private static String smallestString(String str) {
        String result = str;
        for (int i = 0; i < str.length(); i++) {
            if (compare(result, str, i) > 0) {
                result = str.substring(0, i) + (i < str.length() ? str.substring(i + 1) : "");
            }
        }
        return result;
    }

    private static int compare(String str1, String str2, int ignore) {
        int p1 = 0, p2 = 0, len = str1.length();
        for (int i = 0; i < len; i++) {
            if (i == ignore) {
                p2++;
            } else if (str1.charAt(p1) == str2.charAt(p2)) {
                p1++;
                p2++;
            } else {
                return Character.compare(str1.charAt(p1), str2.charAt(p2));
            }
        }
        return 0;
    }
}
