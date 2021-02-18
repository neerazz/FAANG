package contest1487;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 15, 2021
 * Questions: https://codeforces.com/contest/1487/problem/A
 */

public class Arena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            int k = 1;
            while (k < n && nums[k] == nums[0]) k++;
            System.out.println(n - k);
        }
    }
}
