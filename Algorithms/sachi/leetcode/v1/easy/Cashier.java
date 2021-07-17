package leetcode.v1.easy;

import java.util.HashMap;
import java.util.Map;

class Cashier {

    int n = 0;
    int counter = 0;
    int discount = 0;
    int[] products;
    int[] prices;
    Map<Integer, Integer> priceMap = new HashMap<>();

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
        for (int i = 0; i < products.length; i++) {
            priceMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        if (n == ++counter) {
            //Apply discount
            counter = 0;
            double p = getPrice(product, amount);
            return p - (p * discount / 100);
        } else {
            return getPrice(product, amount);
        }

    }

    public double getPrice(int[] product, int[] qty) {
        double p = 0;
        for (int i = 0; i < product.length; i++) {
            p += priceMap.get(product[i]) * qty[i];
        }
        return p;
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        System.out.println(cashier.getBill(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(cashier.getBill(new int[]{3, 7}, new int[]{10, 10}));
        System.out.println(cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));
    }

}