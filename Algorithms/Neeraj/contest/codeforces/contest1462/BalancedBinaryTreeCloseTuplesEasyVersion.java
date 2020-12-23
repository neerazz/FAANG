package contest1462;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 22, 2020
 * Questions: https://codeforces.com/contest/1462/problem/E1
 */

public class BalancedBinaryTreeCloseTuplesEasyVersion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                nums.add(sc.nextInt());
            }
            System.out.println(getTuplesCount(n, nums));
        }
    }

    private static long getTuplesCount(int n, List<Integer> nums) {
        Collections.sort(nums);
//        Two pointer technique
        int p1 = 0, p2 = 0;
        long result = 0;
        while (p1 < n) {
            while (p2 < n && nums.get(p2) <= nums.get(p1) + 2) {
//                Keep expanding the p2 pointer till the selected range falls in the criteria
                p2++;
            }
//            All the numbers between pz and p1 can can form a valid triplet. Use the combination formula n * (n-1) /2
            result += (long) (p2 - p1 - 1) * (p2 - p1 - 1 - 1) / 2;
            p1++;
        }
        return result;
    }
}
