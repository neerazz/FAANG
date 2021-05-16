package weekly.weekly208;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel
 */
public class MaximumProfitOfOperatingACentennialWheel {
    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{8, 3}, 5, 6) + " = 3");
        System.out.println(minOperationsMaxProfit(new int[]{10, 9, 6}, 6, 4) + " = 7");
    }

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = -1, rem = 0, curProfit = 0, rotation = 0, maxValRotation = 0;
        for (int cur : customers) {
            rem += cur;
            int cust = 0;
            if (rem > 4) {
                rem -= cust = 4;
            } else {
                cust = rem;
                rem = 0;
            }
            curProfit += (cust * boardingCost) - runningCost;
            rotation++;
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
                maxValRotation = rotation;
            }
        }
        while (rem > 0) {
            int cust = Math.min(rem, 4);
            rem -= 4;
            curProfit += cust * boardingCost - runningCost;
            rotation++;
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
                maxValRotation = rotation;
            }
        }
        return maxProfit > 0 ? maxValRotation : -1;
    }
}
