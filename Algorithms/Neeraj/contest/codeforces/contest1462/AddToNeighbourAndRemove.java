package contest1462;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 19, 2020
 * Questions: https://codeforces.com/contest/1462/problem/D
 */

public class AddToNeighbourAndRemove {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(getCount(nums, n));
        }
    }

    private static int getCount(int[] nums, int len) {
        int sum = 0;
        for (int num : nums) sum += num;
//        Keep reducing the array size and check array if the sub-array of size i can be formed.
        for (int i = len; i > 0; i--) {
//                If the array can be divided into i parts.
            if (sum % i == 0 && arrayCanBeDivided(nums, sum / i)) return len - i;
        }
        return len - 1;
    }

    private static boolean arrayCanBeDivided(int[] nums, int div) {
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum == div) curSum = 0;
            else if (curSum > div) return false;
        }
        return curSum == 0;
    }
}
