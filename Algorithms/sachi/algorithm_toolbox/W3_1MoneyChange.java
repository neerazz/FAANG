package algorithm_toolbox;//The goal in this problem is to find the minimum number of coins needed to change
//the input value (an integer) into coins with denominations 1, 5, and 10.
//-- Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.

import java.util.Scanner;

public class W3_1MoneyChange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calculateMoneyChangeFast(n));
        scanner.close();
    }

    private static int calculateMoneyChangeFast(int n) {
        int[] denominations = {10, 5, 1};
        int coins = 0, i = 0;
        while (n > 0) {
            int a = 0, sum = 0;
            while (++a * denominations[i] <= n) {
                sum = a * denominations[i];
            }
            coins = coins + a - 1;
            n = n - sum;
            i++;
        }
        return coins;
    }
}
