package algoexpert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<Integer[]> fourNumberSum(int[] arr, int targetSum) {
        List<Integer[]> sol = new ArrayList<>();
        //Sort the arrays
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int start = j + 1, end = arr.length - 1;
                int newTarget = targetSum - arr[i] - arr[j];
                while (start < end) {
                    int sum = arr[start] + arr[end];
                    if (newTarget == sum) {
                        sol.add(new Integer[]{arr[i], arr[j], arr[start], arr[end]});
                        start++;
                        end--;
                    } else if (sum > newTarget) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        List<Integer[]> sol = fourNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
        for (Integer[] intarray : sol) {
            System.out.println(Arrays.toString(intarray));
        }
    }
}
