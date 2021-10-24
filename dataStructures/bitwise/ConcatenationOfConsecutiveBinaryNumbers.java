/**
 * Created on:  Jan 27, 2021
 * Questions: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 */

public class ConcatenationOfConsecutiveBinaryNumbers {

    public static void main(String[] args) {

    }

    public static int concatenatedBinary(int n) {
        long result = 0, mod = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            int lastBit = (int) (Math.log(i) / Math.log(2));
            result <<= (lastBit + 1);
//            System.out.println("lastBit=" + lastBit + " After shifting=" +result + " After adding " + (result | i));
            result |= i;
            result %= mod;
        }
        return (int) result;
    }

    public static int concatenatedBinary_naive(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        long num = 0, mod = 1_000_000_007, mult = 1;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                num = (num + mult) % mod;
            }
            mult <<= 1;
            mult %= mod;
        }
        return (int) (num % mod);
    }
}
