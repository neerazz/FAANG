package easy;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the
 * signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-120));
        System.out.println(reverse(0));
    }


    public static int reverse(int x) {
        //123 -> 321
        // 123 % 10 -> 3
        // 123 / 10 -> 12
        long rev = 0;
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            x = x / 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
        }
        return (int) rev;
    }

    public static int reverseElegant(int x) {
        return 0;
    }

}
