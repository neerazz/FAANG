package contest1472;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 28, 2021
 * Questions:
 */

public class LongJumps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(getBestStartInd(n, nums));
        }
    }

    private static int getBestStartInd(int n, int[] nums) {
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int next = i + nums[i];
            if (next < n) nums[i] += nums[next];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
