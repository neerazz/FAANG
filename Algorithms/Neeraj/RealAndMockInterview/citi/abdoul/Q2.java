package abdoul;

import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 31, 2021
 * Questions:
 */

public class Q2 {

    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 *******************");
        System.out.println(solution(268) + " = 5268");
        System.out.println(solution(670) + " = 6750");
        System.out.println(solution(7643) + " = 76543");
        System.out.println(solution(0) + " = 50");
        System.out.println(solution(-999) + " = -5999");
        System.out.println(solution(-661) + " = -5661");

        System.out.println("*************************** Solution 2 *******************");
        System.out.println(solution_2(268) + " = 5268");
        System.out.println(solution_2(670) + " = 6750");
        System.out.println(solution_2(7643) + " = 76543");
        System.out.println(solution_2(0) + " = 50");
        System.out.println(solution_2(-999) + " = -5999");
        System.out.println(solution_2(-661) + " = -5661");
    }

    private static int solution_2(int N) {
        if (N == 0) return 50;
        int maxVal = Integer.MIN_VALUE, negative = N < 0 ? -1 : 1, pos = 1;
        int len = 0;
        int num = Math.abs(N);
        while (num > 0) {
            len++;
            num /= 10;
        }
        num = Math.abs(N);
//        loop to place digit at every possible position in the number, and check of the new value can be maximum.
        for (int i = 0; i <= len; i++) {
//            Initializing the pos to 1, that means first checking by inserting the digit at 1 position (left most, and then keep moving towards the left).
            int left = (num / pos) * (pos * 10);
            int right = num % pos;
            int newNumber = left + (5 * pos) + right;
            if (newNumber * negative > maxVal) {
                maxVal = newNumber * negative;
            }
            pos *= 10;
        }
        return maxVal;
    }

    private static int solution(int N) {
        boolean isNegative = N < 0;
        Integer result = null;
        String input = String.valueOf(Math.abs(N));
        for (int i = 0; i < input.length(); i++) {
            String temp = input.substring(0, i) + "5" + input.substring(i);
            int newNUmber = Integer.parseInt(temp);
            if (result == null) result = newNUmber;
            else {
                result = isNegative ? Math.min(result, newNUmber) : Math.max(result, newNUmber);
            }
        }
        return isNegative ? -1 * result : result;
    }
}
