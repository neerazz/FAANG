import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/87934981990
 */

public class MaximizeProfit {

    public static void main(String[] args) {
//        System.out.println(maxProfit(2, new int[]{3, 4}, 6) + " = 15");
        System.out.println(maxProfit(5, new int[]{3, 5, 7, 10, 6}, 20) + " = 107");
    }

    private static int maxProfit(int n, int[] arr, int k) {
        int[] counts = new int[100001];
        int max = 0;
        for (int num : arr) {
            counts[num]++;
            max = Math.max(num, max);
        }
        int item = 0, profit = 0;
        for (int i = max; i >= 0 && item < k; i--) {
            int curCount = counts[i];
            if (curCount == 0) continue;
            int taken = Math.min(k - item, curCount);
            profit += i * taken;
            item += taken;
            counts[i] -= taken;
            if (i > 0) counts[i - 1] += taken;
        }
        return profit;
    }
}
