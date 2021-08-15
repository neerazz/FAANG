package leetcode.v2.arraysandstrings;

/*
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
P
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

Example 3:
Input: digits = [0]
Output: [1]
*/

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            if (sum > 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] = sum;
                return digits;
            }
        }
        if (carry == 1) {
            int[] sol = new int[digits.length + 1];
            sol[0] = 1;
            return sol;
        }
        return new int[0];
    }

}