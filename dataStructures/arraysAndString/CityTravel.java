/*
    Created on:  Apr 25, 2020
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/city-travel-59bad87f/
 */
public class CityTravel {
    public static void main(String[] args) {
        FastReader sr = new FastReader();
        int s = sr.nextInt(), x = sr.nextInt(), n = sr.nextInt();
        Map<Integer, Integer> exceptions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            exceptions.put(sr.nextInt(), sr.nextInt());
        }
        int distance = 0, day = 0;
        while (distance <= s) {
            distance += exceptions.getOrDefault(++day, x);
            if (distance >= s) {
                System.out.println(day);
            }
        }
    }
}
