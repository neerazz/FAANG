package weekly.weekly226;

import java.util.*;

/**
 * Created on:  Jan 30, 2021
 * Questions:
 */

public class MaximumNumberOfBallsInABox {

    public static void main(String[] args) {

    }

    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = getSum(i);
            int occ = map.getOrDefault(sum, 0);
            map.put(sum, occ + 1);
            max = Math.max(max, occ + 1);
        }
        return max;
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
