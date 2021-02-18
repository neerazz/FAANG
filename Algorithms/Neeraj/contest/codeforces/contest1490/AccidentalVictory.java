package contest1490;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Feb 16, 2021
 * Questions: https://codeforces.com/contest/1490/problem/E
 */

public class AccidentalVictory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int cur = sc.nextInt();
                map.computeIfAbsent(cur, val -> new HashSet<>()).add(j + 1);
            }
            int[] nums = map.keySet().stream().sorted().mapToInt(val -> val).toArray();
            printPossibleWinner(n, map, nums);
        }
    }

    private static void printPossibleWinner(int n, Map<Integer, Set<Integer>> map, int[] nums) {
        long sum = 0;
        long[] preSum = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = sum;
            sum += (long) nums[i] * map.get(nums[i]).size();
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canWin(map, nums, mid, preSum)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        List<Integer> winners = new ArrayList<>();
        while (start < nums.length) {
            winners.addAll(map.get(nums[start++]));
        }
        System.out.println(winners.size());
        System.out.println(winners.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static boolean canWin(Map<Integer, Set<Integer>> map, int[] nums, int idx, long[] preSum) {
        if (idx == nums.length - 1) return true;
        long curVal = preSum[idx] + ((long) map.get(nums[idx]).size() * nums[idx]);
        while (idx < nums.length - 1) {
            int next = idx + 1;
            if (curVal >= nums[nums.length - 1]) return true;
            else if (curVal >= nums[next]) idx++;
            else return false;
            curVal += ((long) map.get(nums[idx]).size() * nums[idx]);
        }
        return curVal >= nums[nums.length - 1];
    }
}
