package biweekly.biweekly33;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/thousand-separator/
 */
public class ThousandSeparator {
    public static void main(String[] args) {
//        System.out.println(thousandSeparator(0));
        System.out.println(thousandSeparator(987));
        System.out.println(thousandSeparator(1234));
        System.out.println(thousandSeparator(123456789));
    }

    public static String thousandSeparator(int n) {
        String input = String.valueOf(n);
        int processed = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
            processed++;
            if (processed == 3) {
                sb.append(".");
                processed = 0;
            }
        }
        if (processed == 0) sb.deleteCharAt(sb.length() - 1);
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
