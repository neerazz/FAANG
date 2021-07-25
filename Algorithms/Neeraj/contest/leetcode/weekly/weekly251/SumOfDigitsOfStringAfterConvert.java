package weekly.weekly251;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-251/problems/sum-of-digits-of-string-after-convert/
 */
public class SumOfDigitsOfStringAfterConvert {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }

    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        String pre = sb.toString();
        for (int i = 0; i < k; i++) {
            pre = transform(pre);
        }
        return pre.length() == 0 ? 0 : Integer.parseInt(pre);
    }

    private static String transform(String str) {
        long val = 0;
        for (char c : str.toCharArray()) {
            val += (c - '0');
        }
        return String.valueOf(val);
    }
}
