package y2020.RoundG;

import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 18, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/00000000001a0069/0000000000414a24
 */

public class CombinationLock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int w = sc.nextInt(), n = sc.nextInt();
            int[] initial = new int[w];
            for (int j = 0; j < w; j++) {
                initial[j] = sc.nextInt();
            }
//            result[i] = getDistance(w, n, initial);
            result[i] = getDistance_naive(w, n, initial);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getDistance_naive(int w, int n, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int cur = 0;
            for (int j = 0; j < w; j++) {
                int pos = nums[j] <= i ? i - nums[j] : n - nums[j] + i;
                int neg = nums[j] >= i ? nums[j] - i : nums[j] + n - i;
                cur += Math.min(pos, neg);
            }
            min = Math.min(min, cur);
        }
        return min;
    }

    private static int getDistance(int w, int n, int[] initial) {
        if (hasSameValue(initial, w)) return 0;
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(initial);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
//                Change every wheel with a negative and positive value.
                for (int j = 0; j < w; j++) {
                    int[] pos = Arrays.copyOf(poll, w), neg = Arrays.copyOf(poll, w);
                    pos[j] = pos[j] == n ? 0 : pos[j] + 1;
                    neg[j] = neg[j] == 0 ? n : neg[j] - 1;
                    if (hasSameValue(pos, w) || hasSameValue(neg, w)) return level;
                    if (visited.add(Arrays.toString(pos))) queue.add(pos);
                    if (visited.add(Arrays.toString(neg))) queue.add(neg);
                }
            }
        }
        return -1;
    }

    private static boolean hasSameValue(int[] nums, int w) {
        for (int i = 1; i < w; i++) {
            if (nums[i - 1] != nums[i]) return false;
        }
        System.out.println(Arrays.toString(nums));
        return true;
    }
}
