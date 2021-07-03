import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Oct 06, 2020
 * Questions:
 */

public class QuadrupleSumToTarget {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr.length < 4) return quadruplets;
        Arrays.sort(arr);
        QuadrupleSumToTarget.helper(arr, 0, target, 4, new LinkedList<>(), quadruplets);
        return quadruplets;
    }

    private static void helper(int[] arr, int start, int target, int nums, LinkedList<Integer> soFar, List<List<Integer>> op) {
        if (nums == 2) {
            int end = arr.length - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>(soFar);
                    temp.add(arr[start++]);
                    temp.add(arr[end--]);
                    op.add(temp);
                    while (start < end && arr[start] == arr[start + 1]) start++;
                    while (start < end && arr[end] == arr[end - 1]) end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                soFar.add(arr[i]);
                QuadrupleSumToTarget.helper(arr, i + 1, target - arr[i], nums - 1, soFar, op);
                soFar.removeLast();
            }
        }
    }
}
