package contest1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 24, 2020
 * Questions: https://codeforces.com/contest/1420/problem/A
 */
public class CubesSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int test = sc.nextInt();
        while (test-- > 0) {
            int len = sc.nextInt();
            long[] num = new long[len];
            for (int i = 0; i < len; i++) {
                num[i] = sc.nextLong();
            }
//            System.out.println(canSort(len, num) ? "YES" : "NO");
            System.out.println(canSort_Optimal(len, num) ? "YES" : "NO");
        }
    }

    private static boolean canSort_Optimal(int len, long[] nums) {
//        You can make maximum of n! swaps.
//        For each number to reach to its right position in a worst case scenario will require n! swaps.
//        Means No is case only when the number is in reverse order, if you find any number greater then or equal to pre number then it is possible to swap.
//          If a number is greater then or equal to its previous that means you can avoid swaps in between those number and it is possible to swap.
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] <= nums[i]) return true;
        }
        return false;
    }

    private static boolean canSort(int len, long[] nums) {
        int max = (len * (len - 1) / 2) - 1;
        int end = len - 1, swap = 0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < end; i++) {
                if (nums[i] > nums[i + 1]) {
                    swapped = true;
                    long temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                    swap++;
                }
            }
            end--;
            if (swap > max) return false;
        }
        return swap <= max;
    }
}
