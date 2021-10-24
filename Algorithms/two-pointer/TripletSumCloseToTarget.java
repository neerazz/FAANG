import java.util.Arrays;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA
 */

public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 ********************************");
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));

        System.out.println("****************************** Solution 2 ********************************");
        System.out.println(searchTriplet_2(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet_2(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet_2(new int[]{1, 0, 1, 1}, 100));
    }

    public static int searchTriplet_2(int[] arr, int targetSum) {
        int closest = -1, preDiff = Integer.MAX_VALUE, len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (sum == targetSum) return sum;
                int curDiff = Math.abs(targetSum - sum);
                if (preDiff > curDiff || (preDiff == curDiff && sum < closest)) {
                    closest = sum;
                    preDiff = curDiff;
                }
                if (sum > targetSum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return closest;
    }

    public static int searchTriplet(int[] arr, int target) {
        int closest = Integer.MAX_VALUE / 100;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (sum == target) return sum;
                if (Math.abs(closest - target) > Math.abs(sum - target)) {
                    closest = sum;
                } else if (Math.abs(closest - target) == Math.abs(sum - target) && sum < target) {
                    closest = sum;
                }
                if (sum < target) start++;
                else end--;
            }
        }
        return closest;
    }
}
