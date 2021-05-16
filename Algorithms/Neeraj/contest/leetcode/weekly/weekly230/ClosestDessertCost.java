package weekly.weekly230;

/**
 * Created on:  Feb 28, 2021
 * Questions:
 */

public class ClosestDessertCost {

    public static void main(String[] args) {

    }

    static int result;

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        result = baseCosts[0];
        for (int base : baseCosts) {
            getClosest(base, toppingCosts, 0, target);
        }
        return result;
    }

    private static void getClosest(int cost, int[] toppingCosts, int idx, int target) {
        if (Math.abs(target - cost) < Math.abs(target - result) || (Math.abs(target - cost) == Math.abs(target - result) && cost < result)) {
            result = cost;
        }
        if (idx == toppingCosts.length) return;
        getClosest(cost, toppingCosts, idx + 1, target);
        getClosest(cost + toppingCosts[idx], toppingCosts, idx + 1, target);
        getClosest(cost + toppingCosts[idx] + toppingCosts[idx], toppingCosts, idx + 1, target);
    }
}
