package problems.arraysAndString;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (Integer cur : prices) {
            if (cur < min) {
                min = cur;
            } else {
                sum += cur - min;
                min = cur;
            }
        }
        return sum;
    }
}
