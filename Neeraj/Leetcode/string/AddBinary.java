package string;

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
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        char[] aToChars = a.toCharArray();
        char[] bToChars = b.toCharArray();
        int i = 0, j = 0;
        int next = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < aToChars.length || j < bToChars.length) {

        }
        return stringBuilder.toString();
    }
}
