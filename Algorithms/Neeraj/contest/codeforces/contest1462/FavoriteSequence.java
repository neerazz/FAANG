package contest1462;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Dec 19, 2020
 * Questions: https://codeforces.com/contest/1462/problem/A
 */

public class FavoriteSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            int[] result = getActualNumbers(nums, n);
            System.out.println(Arrays.stream(result).boxed().map(Object::toString).collect(Collectors.joining(" ")));
        }
    }

    private static int[] getActualNumbers(int[] nums, int n) {
        int[] result = new int[n];
        int left = 0, right = n - 1, i = 0;
        boolean start = true;
        while (left < right) {
            if (start) {
                result[i++] = nums[left++];
            } else {
                result[i++] = nums[right--];
            }
            start = !start;
        }
        if (left == right) {
            result[i] = nums[left];
        }
        return result;
    }
}
