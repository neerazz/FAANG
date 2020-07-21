/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/add-strings/
 */
public class AddStrings {
    public static void main(String[] args) {

    }

    public static String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 || p2 >= 0) {
            int v1 = p1 >= 0 ? num1.charAt(p1--) - '0' : 0;
            int v2 = p2 >= 0 ? num2.charAt(p2--) - '0' : 0;
            int sum = v1 + v2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
