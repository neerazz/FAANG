import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/add-strings/
 */
public class AddStrings {
    public static void main(String[] args) {
//        System.out.println(addStrings_rev("0", "0"));
        System.out.println(addStrings_rev("1", "9"));
    }

    public static String addStrings_rev(String num1, String num2) {
        int i1 = num1.length() - 1, i2 = num2.length() - 1, carry = 0;
        LinkedList<Character> chars = new LinkedList<>();
        while (i1 >= 0 || i2 >= 0) {
            int v1 = i1 >= 0 ? (num1.charAt(i1--) - '0') : 0;
            int v2 = i2 >= 0 ? (num2.charAt(i2--) - '0') : 0;
            int sum = v1 + v2 + carry;
            chars.addFirst((char) ('0' + sum % 10));
            carry = sum / 10;
        }
        if (carry > 0) chars.addFirst((char) ('0' + carry));
//         Remove the leading zero's
        while (!chars.isEmpty() && chars.getFirst() == '0') {
            chars.removeFirst();
        }
        if (chars.isEmpty()) return "0";
//         Collect all the chars to a string.
        return chars.stream().map(c -> "" + c).collect(Collectors.joining(""));
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
