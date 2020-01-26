package problems.recursion;

import java.util.Arrays;

/*
Problem:
Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        reverseString(input);
        System.out.println(Arrays.toString(input));
    }

    public static void reverseString(char[] s) {
        printInputInReverseOrder(s, 0, s.length - 1);
    }

    public static void printInputInReverseOrder(char[] input, int start, int end) {
        if (start == end || start > end) {
            return;
        }
//        System.out.println(input[length-1]);
        char temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        start++;
        end--;
        printInputInReverseOrder(input, start, end);
    }
}
