package weekly.weekly198;

/**
 * Created on:  Jul 18, 2020
 * Questions: https://leetcode.com/problems/water-bottles/
 * Water Bottles
 */
public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        return helper(numBottles, 0, numExchange);
    }

    private static int helper(int full, int empty, int numExchange) {
        int total = full + empty;
        if (total < numExchange) return full;
        return full + helper(total / numExchange, total % numExchange, numExchange);
    }
}
