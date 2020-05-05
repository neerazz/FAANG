/*
    Created on:  May 04, 2020
 */

import java.math.BigInteger;

/**
 * Questions: https://leetcode.com/problems/number-complement/
 */
public class NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement_optimal(5));
    }
    public static int findComplement_optimal(int num) {
        int cal = num;
        int sum =0;
        while(num >0){
            sum = (sum << 1) + 1;
            num >>=1;
        }
       return sum ^ cal;
    }
    public static int findComplement(int num) {
        String string = Integer.toString(num, 2);
        String replace = string.replace('1', 'o').replace('0', 'z').replace('o', '0').replace('z', '1');
        return Integer.valueOf(replace,2);
    }
}
