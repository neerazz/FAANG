package ds.arraysAndString;

/*
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println("Answer is:" + addBinary("11", "1") + " should be 100");
        System.out.println("Answer is:" + addBinary("1010", "1011") + " should be 10101");
        System.out.println("Answer is:" + addBinary("1111", "1111") + " should be 11110");
    }

    public static String addBinary(String a, String b) {
        char[] aToChars = a.toCharArray();
        char[] bToChars = b.toCharArray();
        int i = aToChars.length - 1, j = bToChars.length - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int aValue = aToChars[i--] == '1' ? 1 : 0;
            int bValue = bToChars[j--] == '1' ? 1 : 0;
            int sum = aValue + bValue + carry;
            if (sum == 2) {
                stringBuilder.append(0);
                carry = 1;
            } else if (sum == 3) {
                stringBuilder.append(1);
                carry = 1;
            } else {
                stringBuilder.append(sum);
                carry = 0;
            }
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}