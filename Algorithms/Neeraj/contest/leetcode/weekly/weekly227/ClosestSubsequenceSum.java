package weekly.weekly227;

import java.util.*;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class ClosestSubsequenceSum {

    public static void main(String[] args) {
        System.out.println(minAbsDifference(new int[]{5, -7, 3, 5}, 6));
        System.out.println(minAbsDifference(new int[]{9210, -5402, 8022, -4660, -1719, -9686, 3899, 8543, -8813, 2070, 3791, 3177, -775, -9400, -7036, -7050, -9843, 2563, -1190, 5216, -1089, 2210, 5775, 1027, 2729, 4947, -6183, 5850, 1616, -5259, 3605, -5142}, -10259));
    }

    static int closest;

    public static int minAbsDifference(int[] nums, int goal) {
        Set<Long> set1 = new HashSet<>();
        TreeSet<Long> set2 = new TreeSet<>();
        int len = nums.length, mid = len / 2;
        bfs(nums, 0, mid, set1);
        bfs(nums, mid + 1, len - 1, set2);
        long diff = Integer.MAX_VALUE;
//        Lop through all the first set and find the diff in second set.
        for (long s1 : set1) {
            long rem = goal - s1;
            Long ceiling = set2.ceiling(rem);
            Long floor = set2.floor(rem);
            if (ceiling != null) diff = Math.min(diff, (int) Math.abs(s1 + ceiling - (long) goal));
            if (floor != null) diff = Math.min(diff, (int) Math.abs(s1 + floor - (long) goal));
        }
        return (int) diff;
    }

    private static void bfs(int[] nums, int start, int end, Set<Long> set) {
        set.add(0L);
        for (int i = start; i <= end; i++) {
            long cur = nums[i];
            Set<Long> temp = new HashSet<>();
            for (long pre : set) {
                temp.add(cur + pre);
            }
            set.addAll(temp);
        }
    }

    public static int minAbsDifference_naive(int[] nums, int goal) {
        closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        helper(nums, 0, 0, goal);
        return closest;
    }

    private static void helper(int[] nums, int i, long total, long goal) {
        int abs = (int) Math.abs(total - goal);
        closest = Math.min(closest, abs);
//        if (abs > closest) return;
        if (i >= nums.length) return;
//        There are two options, one take the  umber the other is dont take the current number;
        helper(nums, i + 1, total, goal);
        helper(nums, i + 1, total + nums[i], goal);
    }
}
