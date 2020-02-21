package algorithms;

import java.text.DecimalFormat;

/*
https://www.hackerrank.com/challenges/plus-minus/problem?h_r=next-challenge&h_v=zen
 */
public class PlusMinus {
    public static void main(String[] args) {
        plusMinus(new int[]{1, 1, 0, -1, -1});
    }

    static void plusMinus(int[] arr) {
        int length = arr.length;
        double positive = 0, negative = 0, zeros = 0;
        for (int i = 0; i < length; i++) {
            int current = arr[i];
            if (current > 0) positive++;
            if (current < 0) negative++;
            if (current == 0) zeros++;
        }
        DecimalFormat df = new DecimalFormat("0.0000##");
        System.out.println(df.format(positive / length));
        System.out.println(df.format(negative / length));
        System.out.println(df.format(zeros / length));
    }
}
