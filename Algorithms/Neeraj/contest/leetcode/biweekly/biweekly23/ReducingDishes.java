package biweekly.biweekly23;

import java.util.Arrays;

/**
 * Crated on:  Apr 04, 2020
 */
public class ReducingDishes {
    public static void main(String[] args) {

    }

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int preSum = 0, cur = 0, result = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
//            Calculate the sum of all the previous satisfactions.
            preSum += satisfaction[i];
//            Add the preSum to current.
//            Note: This will add the previously considered satisfaction, which is equivalent of multiplying.
            cur += preSum;
            result = Math.max(result, cur);
        }
        return result;
    }
}
