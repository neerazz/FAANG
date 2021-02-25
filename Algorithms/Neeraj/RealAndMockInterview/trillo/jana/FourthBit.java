package jana;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class FourthBit {

    public static void main(String[] args) {
        System.out.println(fourthBit(77));
        System.out.println(fourthBit(90998));
    }

    private static int fourthBit(int num) {
        System.out.println(Integer.toBinaryString(num));
        int digit = 0;
        boolean foundOne = false;
        while (num > 0) {
            int bit = num % 2;
            if (bit == 1) {
                foundOne = true;
            }
            if (foundOne) digit++;
            if (digit == 3) return bit;
            num /= 2;
        }
        return 0;
    }
}
