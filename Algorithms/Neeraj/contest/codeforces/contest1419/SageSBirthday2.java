package contest1419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Feb 11, 2021
 * Questions: https://codeforces.com/contest/1419/problem/D2
 */

public class SageSBirthday2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int j = 0; j < n; j++) {
            nums[j]= sc.nextInt();
        }
        getOrder(n, nums);
    }

    private static void getOrder(int n, int[] nums) {
        int p1 = 0, count = 0;
        int[] result = new int[n];
        Arrays.sort(nums);
        for (int i = 1; i < n; i += 2) {
//            Start placing numbers on odd places.
            result[i] = nums[p1++];
        }
        for (int i = 0; i < n; i += 2) {
            result[i] = nums[p1++];
        }
        for (int i = 1; i < n - 1; i++) {
            if (result[i - 1] > result[i] && result[i] < result[i + 1]) count++;
        }
        System.out.println(count);
        System.out.println(Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
