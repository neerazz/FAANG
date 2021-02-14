package contest1419;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 11, 2021
 * Questions: https://codeforces.com/contest/1419/problem/D1
 */

public class SageSBirthday1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int j = 0; j < n; j++) {
            nums[j] = sc.nextInt();
        }
        int max = (n - 1) / 2, p1 = 0, p2 = max;
        System.out.println(max);
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        while (p1 < max) {
            if (sb.length() == 0) {
                sb.append(nums[p2++]).append(" ");
            }
            sb.append(nums[p1++]).append(" ");
            if (p2 < n) sb.append(nums[p2++]).append(" ");
        }
        while (p2 < n) sb.append(nums[p2++]).append(" ");
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
