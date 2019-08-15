
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the 
array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

- Answer
You do not have to calculate till the end. If number is less than n -> increment and return
If coming outside -> create new array n+1 and add 1 in front.

*/

import java.util.Arrays;
import java.util.Scanner;

public class PlusOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        Arrays.stream(plusOne(input)).forEach(e -> System.out.print(e + " "));
        Arrays.stream(plusOneElegant(input)).forEach(e -> System.out.print(e + " "));
        scanner.close();
    }

    public static int[] plusOne(int[] digits) {
        int[] sol = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            sol[i] = sum % 10;
        }
        if (carry > 0) {
            int[] sol1 = new int[digits.length + 1];
            sol1[0] = 1;
            return sol1;
        } else {
            return sol;
        }
    }

    public static int[] plusOneElegant(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] sol = new int[n + 1];
        sol[0] = 1;
        return sol;
    }
}