package InterviewPreparation.arrays;

import java.util.Arrays;

/*
https://www.hackerrank.com/challenges/ctci-array-left-rotation/

 */
public class LeftRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));
        System.out.println(Arrays.toString(rotLeft(new int[]{41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51}, 10)));
    }

    static int[] rotLeft(int[] a, int d) {
        int[] output = new int[a.length];
        int start = 0, second = d;
        for (int i = d; i < a.length; i++) {
            output[start++] = a[second++];
        }
        for (int i = 0; i < d; i++) {
            output[start++] = a[i];
        }
        return output;
    }
}
