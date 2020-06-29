package y2020.RoundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  Jun 22, 2020
 * Questions:
 * There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.
 * What is the maximum number of houses you can buy?
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow.
 * Each test case begins with a single line containing the two integers N and B. The second line contains N integers. The i-th integer is Ai, the cost of the i-th house.
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum number of houses you can buy.
 */
public class Allocation {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int houses = fr.nextInt();
            int budget = fr.nextInt();
            int[] prices = new int[houses];
            for (int j = 0; j < houses; j++) {
                prices[j] = fr.nextInt();
            }
            result[i] = getMaximumHousesThatCanBeBought(budget, prices);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getMaximumHousesThatCanBeBought(int budget, int[] prices) {
        int bought = 0;
        Arrays.sort(prices);
        for (int price : prices) {
            if (budget >= price) {
                bought++;
                budget -= price;
            }
        }
        return bought;
    }
}