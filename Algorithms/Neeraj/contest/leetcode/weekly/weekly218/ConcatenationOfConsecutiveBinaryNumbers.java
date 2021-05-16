package weekly.weekly218;

/**
 * Created on:  Dec 05, 2020
 * Questions:
 */

public class ConcatenationOfConsecutiveBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));
        System.out.println(concatenatedBinary(89567));
    }

    public static int concatenatedBinary(int n) {
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
