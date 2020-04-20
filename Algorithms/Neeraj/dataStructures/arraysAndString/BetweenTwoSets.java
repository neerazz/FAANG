/*
    Created on:  Apr 19, 2020
 */

import java.util.Arrays;
import java.util.List;

/**
 * Questions:
 */
public class BetweenTwoSets {
    public static void main(String[] args) {
        System.out.println(getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96)));
        System.out.println(getTotalX(Arrays.asList(100, 99, 98, 97, 96, 95, 94, 93, 92, 91), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    /**
     * @param a List of integers
     * @param b List of integers
     * @return the count of element's of a is a factor and each is a factor of all elements of b.
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        if (a.isEmpty() || b.isEmpty()) return 0;
        int lcm = a.get(0), gcd = b.get(0), values = 0;
        for (int i : a) {
            lcm = getLCM(lcm, i);
        }
        for (int i : b) {
            gcd = getGCD(gcd, i);
        }
        for (int i = lcm; i <= gcd; i += lcm) {
            if (gcd % i == 0) values++;
        }
        return values;
    }

    private static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    private static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
