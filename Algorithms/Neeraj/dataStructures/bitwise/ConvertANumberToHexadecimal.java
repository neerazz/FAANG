/**
 * Created on:  Oct 06, 2020
 * Questions: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */

public class ConvertANumberToHexadecimal {

    public static void main(final String[] args) {

    }

    public String toHex(final int num) {
        if (num == 0) return "0";
        long cur = num;
        if (num < 0) cur = this.complement(cur);
        String op = "";
        final char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (cur > 0) {
            final int rem = (int) (cur % 16);
            cur /= 16;
            op = map[rem] + op;
        }
        return op;
    }

    long complement(final long n) {
        final long num = n < 0 ? -n : n;
        final long nn = (long) Math.pow(16, 8) - 1;
        return nn ^ num - 1;
    }
}
