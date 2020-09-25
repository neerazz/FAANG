package contest1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 24, 2020
 * Questions: https://codeforces.com/contest/1420/problem/B
 */
public class RockAndLever {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        while (t-- > 0) {
            int len = sc.nextInt();
            long[] nums = new long[len];
            for (int i = 0; i < len; i++) {
                nums[i] = sc.nextLong();
            }
            System.out.println(getPairsCount(len, nums));
        }
    }

    private static int getPairsCount(int len, long[] nums) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                count += (nums[i] & nums[j]) >= (nums[i] ^ nums[j]) ? 1 : 0;
            }
        }
        return count;
    }
}
