package biweekly.biweekly23;

import java.util.HashMap;
import java.util.Map;

/**
 * Crated on:  Apr 04, 2020
 */
public class CountLargestGroup {
    static Map<Integer, Integer> map;
    static int max;

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13) + " should be [4].");
        System.out.println(countLargestGroup(2) + " should be [2].");
        System.out.println(countLargestGroup(15) + " should be [6].");
        System.out.println(countLargestGroup(24) + " should be [5].");
    }

    public static int countLargestGroup(int n) {
        map = new HashMap<>();
        max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            max = Math.max(max, count);
        }
        int output = 0;
        for (int values : map.values()) {
            if (values == max) output++;
        }
        return output;
    }

    private static int getSum(int n) {
        int len = (int) (Math.floor(Math.log10(n)) + 1);
        if (len == 1) return n;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
