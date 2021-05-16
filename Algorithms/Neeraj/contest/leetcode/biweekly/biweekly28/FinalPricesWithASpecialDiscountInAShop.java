package biweekly.biweekly28;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 ******************************");
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(finalPrices(new int[]{10, 1, 1, 6})));
        System.out.println("********************************** Solution 2 ******************************");
        System.out.println(Arrays.toString(finalPrices_Optimal(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices_Optimal(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(finalPrices_Optimal(new int[]{10, 1, 1, 6})));
    }

    public static int[] finalPrices_Optimal(int[] A) {
//        Go forward and and you encounter a less value in past then reduce the past value by the current and remove it from stack.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                A[stack.pop()] -= A[i];
            stack.push(i);
        }
        return A;
    }

    public static int[] finalPrices(int[] prices) {
        int[] op = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            op[i] = prices[i] - getlowest(prices, i);
        }
        return op;
    }

    private static int getlowest(int[] prices, int from) {
        int cur = prices[from];
        for (int i = from + 1; i < prices.length; i++) {
            if (prices[i] <= cur) {
                return prices[i];
            }
        }
        return 0;
    }
}
