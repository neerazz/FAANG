package contest1208;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Feb 19, 2021
 * Questions: https://codeforces.com/contest/1208/problem/B
 */

public class Uniqueness {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(minDeleting(n, nums));
    }

    private static int minDeleting(int n, int[] nums) {
        int min = Integer.MAX_VALUE;
//        Collect all the numbers and its occurrence in a map.
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> dups = new HashSet<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) dups.add(num);
        }
        if (dups.size() == 0) return 0;
//        Find the smaller sub-array that has all the duplicates, with actual occurrence-1 (Because our resulting array can have one number).
        Map<Integer, Integer> window = new HashMap<>();
        int p1 = 0, found = 0;
        for (int p2 = 0; p2 < n; p2++) {
            int v2 = nums[p2];
            window.put(v2, window.getOrDefault(v2, 0) + 1);
            if (map.get(v2) - 1 == window.get(v2)) found++;
            while (found == dups.size() && p1 < p2) {
                min = Math.min(min, p2 - p1 + 1);
//                Then reduce the slider, when all the duplicates are found.
                int v1 = nums[p1++];
                int count = window.remove(v1);
//                If p1 pointer is at a number that is a duplicate and the occurrence in window is one less then the actual occurrence, then the sub-array is not valid.
                if (dups.contains(v1) && count == map.get(v1) - 1) found--;
                if (count-- > 1) window.put(v1, count);
            }
        }
        return min;
    }
}
