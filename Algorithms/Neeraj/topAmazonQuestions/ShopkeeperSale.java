import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-shopkeeper-sale
 */

public class ShopkeeperSale {

    public static void main(String[] args) {
        sell(new int[]{2, 3, 1, 2, 4, 2});
        sell(new int[]{5, 1, 3, 4, 6, 2});
        sell(new int[]{1, 3, 3, 2, 5});
    }

    private static void sell(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        List<Integer> fullPriced = new ArrayList<>();
        boolean[] changed = new boolean[prices.length];
//        0: idx, 1 : val
        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty()) {
                boolean foundGreater = false;
                while (!stack.isEmpty() && stack.peek()[1] >= prices[i]) {
                    int[] peek = stack.pop();
//                    Reduce the price at the previous index.
                    prices[peek[0]] -= prices[i];
                    foundGreater = changed[peek[0]] = true;
                }
                if (!foundGreater) {
                    stack.add(new int[]{i, prices[i]});
                }
            } else {
                stack.add(new int[]{i, prices[i]});
            }
        }
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            if (!changed[i]) fullPriced.add(i);
            total += prices[i];
        }
        System.out.println("Total = " + total);
        System.out.println(fullPriced);
    }

    private static void sell_wrong(int[] prices) {
        int len = prices.length, right[] = new int[len];
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (min <= prices[i])
                right[i] = min;
            else right[i] = -1;
            min = Math.min(min, prices[i]);
        }
        int total = 0;
        List<Integer> fullPriced = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (right[i] != -1) {
                total += prices[i] - right[i];
            } else {
                total += prices[i];
                fullPriced.add(i);
            }
        }
        System.out.println("Total = " + total);
        System.out.println(fullPriced);
    }
}
