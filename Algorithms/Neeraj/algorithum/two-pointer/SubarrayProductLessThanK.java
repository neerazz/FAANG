import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/RMV1GV1yPYz
 * Problem Statement #
 * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * Example 2:
 * <p>
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 */

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 ********************************");
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{8, 2, 6, 5}, 50));

        System.out.println("****************************** Solution 2 ********************************");
        System.out.println(SubarrayProductLessThanK.findSubarrays_rev1(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays_rev1(new int[]{8, 2, 6, 5}, 50));

        System.out.println("****************************** Solution 3 ********************************");
        System.out.println(SubarrayProductLessThanK.findSubarrays_rev2(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays_rev2(new int[]{8, 2, 6, 5}, 50));
    }

    public static List<List<Integer>> findSubarrays_rev2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int p1 = 0, p2 = 0, len = arr.length;
        double product = 1;
        while (p2 < len) {
            product *= arr[p2];
//            Shrink if the product is great then or equal to target.
            while (p1 <= p2 && product >= target) {
                product /= arr[p1++];
            }
//            Loop through the window and collect the List.
            List<Integer> level = new ArrayList<>();
            for (int i = p2; i >= p1; i--) {
                level.add(arr[i]);
                result.add(new ArrayList<>(level));
            }
            p2++;
        }
        return result;
    }

    public static List<List<Integer>> findSubarrays_rev1(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.addFirst(arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        int p1 = 0;
        long product = 1;
        for (int p2 = 0; p2 < arr.length; p2++) {
            if (arr[p2] < target) {
                subarrays.add(Arrays.asList(arr[p2]));
            }
            product *= arr[p2];
            while (p1 < p2 && product >= target) {
                product /= arr[p1++];
            }
            if (product < target && p1 != p2) {
                List<Integer> list = new ArrayList<>();
                for (int i = p1; i <= p2; i++) list.add(arr[i]);
                subarrays.add(list);
            }
        }
        return subarrays;
    }
}
