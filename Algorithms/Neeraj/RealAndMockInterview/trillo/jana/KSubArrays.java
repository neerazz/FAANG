package jana;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class KSubArrays {

    public static void main(String[] args) {
        System.out.println(kSub(5, new int[]{5, 10, 11, 9, 5}));
    }

    private static int kSub(int k, int[] arr) {
        long[] rems = new long[k + 1];
        long sum = 0;
        for (int j : arr) {
            sum += j;
//            Adding a K so that negative sum is also taken care.
            int rem = (int) (sum % k);
            rems[rem]++;
        }
        int count = 0;
        for (long rem : rems) {
            if (rem > 1) {
                count += rem * (rem - 1) / 2;
            }
        }
        return (int) (count + rems[0]);
    }
}
