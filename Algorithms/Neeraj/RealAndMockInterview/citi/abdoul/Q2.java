package abdoul;

import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 31, 2021
 * Questions:
 */

public class Q2 {

    public static void main(String[] args) {
        System.out.println(solution(268));
        System.out.println(solution(670));
        System.out.println(solution(0));
        System.out.println(solution(-999));
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
