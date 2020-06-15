import java.util.Scanner;

//TODO: Come and solve this question again
public class StocksSellBuy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stocks = new int[n];
        for (int i = 0; i < n; i++) {
            stocks[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(getMaxProfit(stocks));
    }

    public static int getMaxProfit(int[] stockPrices) {
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < stockPrices.length; i++) {
            for (int j = i + 1; j < stockPrices.length; j++) {
                profit = Math.max(profit, stockPrices[j] - stockPrices[i]);
            }
        }
        return profit;
    }
}