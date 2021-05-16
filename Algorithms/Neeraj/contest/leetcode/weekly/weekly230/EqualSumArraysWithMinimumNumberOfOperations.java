package weekly.weekly230;

import java.util.*;

/**
 * Created on:  Feb 27, 2021
 * Questions:
 */

public class EqualSumArraysWithMinimumNumberOfOperations {

    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 ******************************");
        System.out.println(minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}) + " = 3");
        System.out.println(minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}) + " = -1");
        System.out.println(minOperations(new int[]{6, 6}, new int[]{1}) + " = 3");
        System.out.println(minOperations(new int[]{5, 6, 4, 3, 1, 2}, new int[]{6, 3, 3, 1, 4, 5, 3, 4, 1, 3, 4}) + " = 4");
        System.out.println(minOperations(new int[]{3, 3, 2, 4, 2, 6, 2}, new int[]{6, 2, 6, 6, 1, 1, 4, 6, 4, 6, 2, 5, 4, 2, 1}) + " = 8");

        System.out.println("*************************** Solution 2 ******************************");
        System.out.println(minOperations_optimal(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}) + " = 3");
        System.out.println(minOperations_optimal(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}) + " = -1");
        System.out.println(minOperations_optimal(new int[]{6, 6}, new int[]{1}) + " = 3");
        System.out.println(minOperations_optimal(new int[]{5, 6, 4, 3, 1, 2}, new int[]{6, 3, 3, 1, 4, 5, 3, 4, 1, 3, 4}) + " = 4");
        System.out.println(minOperations_optimal(new int[]{3, 3, 2, 4, 2, 6, 2}, new int[]{6, 2, 6, 6, 1, 1, 4, 6, 4, 6, 2, 5, 4, 2, 1}) + " = 8");
    }

    public static int minOperations_optimal(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) return -1;
        int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
//        Make sure that nums1 array has less sum then nums2
        if (sum1 > sum2) {
            int[] temp = Arrays.copyOf(nums1, nums1.length);
            nums1 = nums2;
            nums2 = temp;
            int t2 = sum1;
            sum1 = sum2;
            sum2 = t2;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i : nums1) pq1.offer(i);
        for (int i : nums2) pq2.offer(i);
        int result = 0;
        while (sum1 < sum2) {
            result++;
            if (pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek())
                sum1 += 6 - pq1.poll();
            else
                sum2 -= pq2.poll() - 1;
        }
        return result;
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        int[] occ1 = getOccurrence(nums1), occ2 = getOccurrence(nums2);
        Set<String> visited = new HashSet<>();
        PriorityQueue<Values> pq = new PriorityQueue<>((v1, v2) -> Long.compare(Math.abs(v1.s1 - v1.s2), Math.abs(v2.s1 - v2.s2)));
        Values val = new Values(occ1, occ2, 0);
        pq.add(val);
        visited.add(val.getHash());
        while (!pq.isEmpty()) {
            Values poll = pq.poll();
//            System.out.println(poll);
            long diff = poll.s1 - poll.s2;
            int change = poll.change;
            if (diff == 0) return change;
            if (diff >= -5 && diff <= 5 && poll.isPossibleByOneMove()) return change + 1;
            int[] c1 = Arrays.copyOf(poll.arr1, 7), c2 = Arrays.copyOf(poll.arr2, 7);
            if (poll.s1 > poll.s2) {
//                max reduce from arr1 and max increase from array2
                if (maxReduce(poll.arr1)) {
                    Values v2 = new Values(poll.arr1, c2, change + 1);
                    if (visited.add(v2.getHash())) pq.add(v2);
                }
                if (maxIncrease(poll.arr2)) {
                    Values v1 = new Values(c1, poll.arr2, change + 1);
                    if (visited.add(v1.getHash())) pq.add(v1);
                }
            } else {
//                max reduce from arr2 and max increase from array1
                if (maxReduce(poll.arr2)) {
                    Values v1 = new Values(c1, poll.arr2, change + 1);
                    if (visited.add(v1.getHash())) pq.add(v1);
                }
                if (maxIncrease(poll.arr1)) {
                    Values v2 = new Values(poll.arr1, c2, change + 1);
                    if (visited.add(v2.getHash())) pq.add(v2);
                }
            }
        }
        return -1;
    }

    private static boolean maxIncrease(int[] nums) {
//        only one max increase
        for (int j = 1; j < 6; j++) {
            if (nums[j] > 0) {
                nums[j]--;
                nums[6]++;
                return true;
            }
        }
        return false;
    }

    private static boolean maxReduce(int[] nums) {
//        only one max increase
        for (int i = 6; i > 1; i--) {
            if (nums[i] > 0) {
                nums[i]--;
                nums[1]++;
                return true;
            }
        }
        return false;
    }

    private static int[] getOccurrence(int[] nums) {
        int[] counts = new int[7];
        for (int num : nums) counts[num]++;
        return counts;
    }

    static class Values {
        int[] arr1, arr2;
        long s1, s2;
        int change;

        public Values(int[] arr1, int[] arr2, int change) {
            this.arr1 = Arrays.copyOf(arr1, 7);
            this.arr2 = Arrays.copyOf(arr2, 7);
            this.change = change;
            for (int i = 1; i < 7; i++) {
                s1 += (long) arr1[i] * i;
                s2 += (long) arr2[i] * i;
            }
        }

        String getHash() {
            return s1 + " " + s2;
        }

        boolean isPossibleByOneMove() {
//            System.out.println("Called is Possible for on  " + this);
//            Check if the greater array can be reduced by diff, or smaller array can be increased by diff
            return check(arr1, s1, s2) || check(arr2, s2, s1);
        }

        private boolean check(int[] occ, long from, long to) {
            for (int i = 1; i <= 6; i++) {
                if (occ[i] > 0) {
                    for (int j = 1; j <= 6; j++) {
                        if (from + (j - i) == to) return true;
                    }
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return "Values{" +
                    "arr1=" + Arrays.toString(arr1) +
                    ", arr2=" + Arrays.toString(arr2) +
                    ", s1=" + s1 +
                    ", s2=" + s2 +
                    ", change=" + change +
                    '}';
        }
    }
}
