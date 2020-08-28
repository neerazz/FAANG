package practice;

import java.util.Arrays;

/**
 * Created on:  Aug 26, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=146466059993201
 */
public class PassingYearbooks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSignatureCounts(new int[]{2, 1})) + " = [2,2]");
        System.out.println(Arrays.toString(findSignatureCounts(new int[]{1, 2})) + " = [1,1]");
        System.out.println(Arrays.toString(findSignatureCounts(new int[]{1, 2, 3})) + " = [1,1,1]");
    }

    static int[] findSignatureCounts(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int sign = 1, pass = arr[i] - 1;
            while (pass != i) {
                sign++;
                pass = arr[pass] - 1;
            }
            result[i] = sign;
        }
        return result;
    }
}
