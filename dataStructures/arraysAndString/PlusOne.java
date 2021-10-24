import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/

Understand Question.
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println("Answer is: " + Arrays.toString(plusOne(new int[]{3, 6, 1, 0})) + " should be 1.");
    }

    public static int[] plusOne(int[] digits) {
        int carry = 1, len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
        }
        if (carry == 0) return digits;
        int[] temp = new int[len + 1];
        temp[0] = carry;
        System.arraycopy(digits, 0, temp, 1, len);
        return temp;
    }
}
