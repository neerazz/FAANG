package weekly.weekly246;

/**
 * Created on:  Jun 19, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-246/problems/largest-odd-number-in-string/
 */

public class LargestOddNumberInString {

    public static void main(String[] args) {

    }

    public String largestOddNumber_2(String num) {
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            if (cur % 2 == 1) return num.substring(0, i + 1);
        }
        return "";
    }

    public String largestOddNumber(String num) {
        String result = "";
        int len = num.length();
        for (int i = 0; i < len; i++) {
            int cur = num.charAt(i) - '0';
            if (cur % 2 == 1) {
//                String soFar = num.substring(0, i + 1);
//                if (soFar.compareTo(result) > 0) {
//                    result = soFar;
//                }
                result = num.substring(0, i + 1);
            }
        }
        return result;
    }
}
