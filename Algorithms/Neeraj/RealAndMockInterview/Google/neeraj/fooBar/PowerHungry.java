package neeraj.fooBar;
/*
    Created on:  May 12, 2020
 */

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Questions:
 * Power Hungry
 * ============
 * <p>
 * Commander Lambda's space station is HUGE. And huge space stations take a LOT of power. Huge space stations with doomsday devices take even more power.
 * To help meet the station's power needs, Commander Lambda has installed solar panels on the station's outer surface.
 * But the station sits in the middle of a quasar quantum flux field, which wreaks havoc on the solar panels.
 * You and your team of henchmen have been assigned to repair the solar panels,
 * but you'd rather not take down all of the panels at once if you can help it, since they do help power the space station and all!
 * <p>
 * You need to figure out which sets of panels in any given array you can take offline to repair while still maintaining the maximum amount of power output per array,
 * and to do THAT, you'll first need to figure out what the maximum output of each array actually is.
 * <p>
 * Write a function solution(xs) that takes a list of integers representing the power output levels of each panel in an array,
 * and returns the maximum product of some non-empty subset of those numbers.
 * So for example, if an array contained panels with power output levels of [2, -3, 1, 0, -5], then the maximum product would be found by taking the subset:
 * xs[0] = 2, xs[1] = -3, xs[4] = -5, giving the product 2*(-3)*(-5) = 30.
 * So solution([2,-3,1,0,-5]) will be "30".
 * <p>
 * Each array of solar panels contains at least 1 and no more than 50 panels,
 * and each panel will have a power output level whose absolute value is no greater than 1000 (some panels are malfunctioning so badly that they're draining energy,
 * but you know a trick with the panels' wave stabilizer that lets you combine two negative-output panels to produce the positive output of the multiple of their power values).
 * The final products may be very large, so give the solution as a string representation of the number.
 * <p>
 * Languages
 * =========
 * <p>
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit Solution.java
 * <p>
 * Test cases
 * ==========
 * Your code should pass the following test cases.
 * Note that it may also be run against hidden test cases not shown here.
 * <p>
 * Input:
 * Solution.solution({2, 0, 2, 2, 0})
 * Output:
 * 8
 * Input:
 * Solution.solution({-2, -3, 4, -5})
 * Output:
 * 60
 */
public class PowerHungry {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 0, 2, 2, 0}) + " should be [8]");
        System.out.println(solution(new int[]{9}) + " should be [9]");
        System.out.println(solution(new int[]{0}) + " should be [0]");
        System.out.println(solution(new int[]{-2}) + " should be [-2]");
        System.out.println(solution(new int[]{-2, -3, 4, -5}) + " should be [60]");
        System.out.println("******************** Optimal Solution **********************");
        System.out.println(solution_optimal(new int[]{2, 0, 2, 2, 0}) + " should be [8]");
        System.out.println(solution_optimal(new int[]{9}) + " should be [9]");
        System.out.println(solution_optimal(new int[]{0}) + " should be [0]");
        System.out.println(solution_optimal(new int[]{-2}) + " should be [-2]");
        System.out.println(solution_optimal(new int[]{-2, -3, 4, -5}) + " should be [60]");
    }

    public static String solution_optimal(int[] xs) {
        if (xs.length == 1) return String.valueOf(xs[0]);
        LinkedList<Integer> negative = new LinkedList<>();
        BigInteger pos = BigInteger.ONE, neg = BigInteger.ONE;
        for (int num : xs) {
            if (num > 0) {
                pos = pos.multiply(BigInteger.valueOf(num));
            } else if (num < 0) {
                negative.add(num);
            }
        }
        Collections.sort(negative);
        if (negative.size() % 2 == 1) negative.removeLast();
        for (int num : negative) {
            neg = neg.multiply(BigInteger.valueOf(num));
        }
        return pos.multiply(neg).toString();
    }

    public static String solution(int[] xs) {
        if (xs.length == 1) return String.valueOf(xs[0]);
        BigInteger bigInt = BigInteger.ONE, max = BigInteger.ZERO;
        List<Integer> sorted = Arrays.stream(xs).boxed().filter(val -> val != 0).sorted().collect(Collectors.toList());
        int p1 = 0, p2 = sorted.size() - 1;
        while (p1 < p2) {
            long multplied = sorted.get(p1) * sorted.get(p2);
            if (multplied < 1) {
                if (sorted.get(p1 + 1) < 0) {
                    multplied *= sorted.get(p1 + 1);
                } else {
                    multplied = sorted.get(p1 + 1) * sorted.get(p2);
                }
                p1++;
            }
            bigInt = bigInt.multiply(BigInteger.valueOf(multplied));
            p1++;
            p2--;
            if (bigInt.compareTo(max) > 0) {
                max = bigInt;
            }
            if (p1 == p2) {
                BigInteger multiply = bigInt.multiply(BigInteger.valueOf(sorted.get(p1)));
                if (multiply.compareTo(max) > 0) max = multiply;
            }
        }
        return max.toString();
    }
}
