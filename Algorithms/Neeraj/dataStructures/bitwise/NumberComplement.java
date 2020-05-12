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
        int temp = num;
        int allOnes =0;
//        Loop till the binary value is greater than zero. And keep shifting and adding 1.
//        So that binary representation of allOnes will be all 1's.
//        Ex: num = 5 (101), then loop till allOnes = (111),
//          And then do an XOR of allOnes & num. It will give (010).
        while(temp >0){
            allOnes = (allOnes << 1) + 1;
            temp >>=1;
        }
       return allOnes ^ num;
    }
    public static int findComplement(int num) {
        String string = Integer.toString(num, 2);
        String replace = string.replace('1', 'o').replace('0', 'z').replace('o', '0').replace('z', '1');
        return Integer.valueOf(replace,2);
    }
}
