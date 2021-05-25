package y2021.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created on:  May 16, 2021
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a885
 */

public class TruckDelivery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {

            result[i] = -1;
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }
}
