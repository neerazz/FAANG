package y2020.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created on:  Aug 11, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d83bf
 */
public class BusRoutes {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
            long days = fr.nextLong();
            long[] buses = new long[n];
            for (int j = 0; j < n; j++) {
                buses[j] = fr.nextLong();
            }
            result[i] = getMaxStartingDay(n, days, buses);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long getMaxStartingDay(int n, long days, long[] buses) {
        long maxDay = days, curDay = days;
        for (int i = n - 1; i >= 0; i--) {
            curDay = findClosestDay(curDay, buses[i]);
//            System.out.println("curDay = " + curDay);
            maxDay = Math.min(maxDay, curDay);
        }
        return maxDay;
    }

    private static long findClosestDay(long days, long cur) {
        return days - (days % cur);
    }
}
