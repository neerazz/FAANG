package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> sol = new ArrayList<>();
        //Sort the arrays
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            getTwoSum(array, i + 1, targetSum - array[i], sol);
        }
        return sol;
    }

    public static void getTwoSum(int[] arr, int start, int target, List<Integer[]> sol) {
        int myStart = start - 1;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                sol.add(new Integer[]{arr[myStart], arr[start], arr[end]});
                start++;
                end--;
            } else if (target < sum) {
                end--;
            } else {
                start++;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer[]> sol = threeNumberSum(new int[]{1, 2, 3}, 6);
        for (Integer[] intarray : sol) {
            System.out.println(Arrays.toString(intarray));
        }
    }
}
