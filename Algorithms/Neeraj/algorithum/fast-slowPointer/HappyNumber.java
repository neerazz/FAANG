import java.util.HashSet;

/**
 * Created on:  Jul 06, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM
 */

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println("******************** Revision 1 **************************");
        System.out.println(isHappy_rev(19) + " should be [true].");
        System.out.println(isHappy_rev(2) + " should be [false].");
        System.out.println(isHappy_rev(4) + " should be [false].");
        System.out.println(isHappy_rev(7) + " should be [true].");
        System.out.println("******************** Revision 2 **************************");
        System.out.println(isHappy(19) + " should be [true].");
        System.out.println(isHappy(2) + " should be [false].");
        System.out.println(isHappy(4) + " should be [false].");
        System.out.println(isHappy(7) + " should be [true].");
    }

    public static boolean isHappy_rev(int num) {
        if (num <= 0) return false;
        int slow = num, fast = num;
        while (slow > 1 && fast > 1) {
            slow = solve(slow, 1);
            fast = solve(fast, 2);
            if (slow == fast) return false;
        }
        return slow == 1 || fast == 1;
    }

    static int solve(int num, int times) {
        while (times-- > 0) {
            int cur = 0;
            while (num > 0) {
                int dec = num % 10;
                cur += dec * dec;
                num /= 10;
            }
            num = cur;
        }
        return num;
    }


    static HashSet<Integer> set = new HashSet<>();

    public static boolean isHappy(int n) {
        if (n == 1) return true;
        if (n < 4 || set.contains(n)) return false;
        return isHappy(squareSumNumber(n));
    }

    private static int squareSumNumber(int n) {
        set.add(n);
        int len = (int) Math.floor(Math.log10(n)) + 1;
        if (len == 1) {
            return n * n;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int temp = (int) (n / Math.pow(10, i));
            int val = temp % 10;
            sum += val * val;
        }
        return sum;
    }
}
