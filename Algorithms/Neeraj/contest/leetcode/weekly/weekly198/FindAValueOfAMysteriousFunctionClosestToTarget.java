package weekly.weekly198;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Jul 18, 2020
 * Questions:
 * Find a Value of a Mysterious Function Closest to Target
 */
public class FindAValueOfAMysteriousFunctionClosestToTarget {
    public static void main(String[] args) {
        System.out.println(closestToTarget(new int[]{9, 12, 3, 7, 15}, 5) + " = [2]");
        System.out.println(closestToTarget(new int[]{1000000, 1000000, 1000000}, 1) + " = [999999]");
        System.out.println(closestToTarget(new int[]{1, 2, 4, 8, 16}, 0) + " = [0]");
        System.out.println(closestToTarget(new int[]{5, 89, 79, 44, 45, 79}, 965) + " = [876]");
    }

    /**
     * @implSpec a & b  will always be less than or equal to max (a,b). Because & operation will make a bit to zero in all the cases except when both of them are 1.
     * There we will sort he array in ascending order. And for every element keep finding the and with the remaining.
     * When the values goes below target, then exit the inner loop, and when the value goes above the target, then exit the outer loop.
     */
    public static int closestToTarget(int[] arr, int target) {
        int op = Integer.MAX_VALUE;
        List<Integer> uniqueSorted = Arrays.stream(arr).boxed().distinct().sorted().collect(Collectors.toList());
        for (int i = 0; i < uniqueSorted.size(); i++) {
            int sum = uniqueSorted.get(i);
            for (int j = i + 1; j < uniqueSorted.size(); j++) {
                op = Math.min(op, Math.abs(sum - target));
                sum &= uniqueSorted.get(j);
//                This condition to check is sum is negative. Then the result of the expression cannot be minimum.
                if (sum <= target) break;
            }
//            If the sum after all the and operations are above the target, the future sum wont be smaller.
            op = Math.min(op, Math.abs(sum - target));
            if (sum > target) break;
        }
        return op;
    }
}
