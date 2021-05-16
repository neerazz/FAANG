package weekly.weekly233;

import java.util.*;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class NumberOfOrdersInTheBacklog {

    public static void main(String[] args) {
//        System.out.println(getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        System.out.println(getNumberOfBacklogOrders(new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}));
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
//        0: price, 1: quantity
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int[] order : orders) {
            int price = order[0], quantity = order[1], type = order[2];
            if (type == 0) {
//                Buy order
                while (quantity > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] poll = sell.poll();
                    int filled = Math.min(quantity, poll[1]);
                    quantity -= filled;
                    poll[1] -= filled;
                    if (poll[1] > 0) sell.add(poll);
                }
                if (quantity > 0) buy.add(new int[]{price, quantity});
            } else {
//                Sell order
                while (quantity > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] poll = buy.poll();
                    int filled = Math.min(quantity, poll[1]);
                    quantity -= filled;
                    poll[1] -= filled;
                    if (poll[1] > 0) buy.add(poll);
                }
                if (quantity > 0) sell.add(new int[]{price, quantity});
            }
        }
        long backLog = 0, mod = 1_000_000_007;
        while (!buy.isEmpty()) {
            backLog += buy.poll()[1];
            backLog %= mod;
        }
        while (!sell.isEmpty()) {
            backLog += sell.poll()[1];
            backLog %= mod;
        }
        return (int) (backLog % mod);
    }
}
