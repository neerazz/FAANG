/**
 * Created on:  Jul 12, 2020
 * Questions: https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(0b10000000000000000000000000000000));
    }

    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
